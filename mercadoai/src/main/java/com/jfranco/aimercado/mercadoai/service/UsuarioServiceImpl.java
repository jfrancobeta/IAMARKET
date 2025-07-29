package com.jfranco.aimercado.mercadoai.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.RegistroRequest;
import com.jfranco.aimercado.mercadoai.model.PerfilCompania;
import com.jfranco.aimercado.mercadoai.model.PerfilDesarrollador;
import com.jfranco.aimercado.mercadoai.model.Role;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.model.Notification.Notification;
import com.jfranco.aimercado.mercadoai.repository.CompaniaRepository;
import com.jfranco.aimercado.mercadoai.repository.DesarrolladorRepository;
import com.jfranco.aimercado.mercadoai.repository.UsuarioRepository;
import com.jfranco.aimercado.mercadoai.service.notifications.INotificationService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CompaniaRepository companiaRepository;

    @Autowired
    private DesarrolladorRepository desarrolladorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private INotificationService notificationService;

     
    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void saveUsuario(RegistroRequest registroRequest) {
        Usuario usuario =  new Usuario();
        usuario.setUsername(registroRequest.getUsername());
        usuario.setEmail(registroRequest.getEmail());
        usuario.setPassword(passwordEncoder.encode(registroRequest.getPassword())); // Asegúrate de encriptar la contraseña
        usuario.setUserType(registroRequest.getUserType());
        usuario.setNombre(registroRequest.getNombre());
        usuario.setDescripcion(registroRequest.getDescripcion());
        usuario.setRoles(Arrays.asList(new Role(1L,"ROLE_USER")));
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setEstado(true);

        usuario = usuarioRepository.save(usuario);

        // Crear el perfil según el tipo de usuario
        if (registroRequest.getUserType() == 1) { // Desarrollador
            PerfilDesarrollador desarrollador = new PerfilDesarrollador();
            desarrollador.setUsuario(usuario);
            desarrollador.setHabilidades(registroRequest.getHabilidades());
            desarrollador.setExperiencia(registroRequest.getExperiencia());
            desarrollador.setPortafolioURL(registroRequest.getPortafolioURL());
            desarrolladorRepository.save(desarrollador);
        } else if (registroRequest.getUserType() == 0) { // Compañía
            PerfilCompania compania = new PerfilCompania();
            compania.setUsuario(usuario);
            compania.setNombreCompania(registroRequest.getNombreCompania());
            compania.setIndustria(registroRequest.getIndustria());
            compania.setUbicacion(registroRequest.getUbicacion());
            compania.setWebsite(registroRequest.getWebsite());
            companiaRepository.save(compania);
        }
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        usuario.setEstado(false); // Cambiar el estado a inactivo en lugar de eliminar
        usuarioRepository.save(usuario);
    }

    

    // --- Recuperación de contraseña con código de 6 dígitos (en memoria) ---
    private Map<String, String> resetCodes = new HashMap<>();

    @Override
    public boolean sendResetCode(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (!usuario.isPresent()) {
            return false;
        }
        // Generar código de 6 dígitos
        String code = String.format("%06d", new Random().nextInt(999999));
        resetCodes.put(email, code);

        Notification notification = new Notification();
        notification.setEmail(email);
        notification.setTitle("Código de recuperación de contraseña");
        notification.setMessage("Tu código de recuperación es: " + code);
        notificationService.createNotification(notification);

        return true;
    }

    @Override
    public boolean verifyResetCode(String email, String code) {
        String storedCode = resetCodes.get(email);
        return storedCode != null && storedCode.equals(code);
    }

    @Override
    public boolean resetPassword(String email, String code, String newPassword) {
        if (!verifyResetCode(email, code)) {
            return false;
        }
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (!usuario.isPresent()) {
            return false;
        }
        usuario.get().setPassword(passwordEncoder.encode(newPassword));
        usuarioRepository.save(usuario.get());
        resetCodes.remove(email); 
        return true;
    }
    
}
