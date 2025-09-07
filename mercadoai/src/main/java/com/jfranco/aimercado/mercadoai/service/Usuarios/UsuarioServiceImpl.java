package com.jfranco.aimercado.mercadoai.service.Usuarios;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.Auth.RegistroRequest;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.model.Notification;
import com.jfranco.aimercado.mercadoai.model.PerfilCompania;
import com.jfranco.aimercado.mercadoai.model.PerfilDesarrollador;
import com.jfranco.aimercado.mercadoai.model.Role;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.repository.Habilidad.HabilidadRepository;
import com.jfranco.aimercado.mercadoai.repository.Industria.IndustriaRepository;
import com.jfranco.aimercado.mercadoai.repository.Pais.PaisRepository;
import com.jfranco.aimercado.mercadoai.repository.Perfiles.CompaniaRepository;
import com.jfranco.aimercado.mercadoai.repository.Perfiles.DesarrolladorRepository;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;
import com.jfranco.aimercado.mercadoai.service.notifications.INotificationService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

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

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private IndustriaRepository industriaRepository;

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void saveUsuario(RegistroRequest registroRequest) {
        Usuario usuario = new Usuario();

        if (registroRequest.getPais() != null) {
            usuario.setPais(paisRepository.findById(registroRequest.getPais()).orElse(null));
        }

        usuario.setUsername(registroRequest.getUsername());
        usuario.setEmail(registroRequest.getEmail());
        usuario.setPassword(passwordEncoder.encode(registroRequest.getPassword())); 
        usuario.setUserType(registroRequest.getUserType());
        usuario.setNombre(registroRequest.getNombre());
        usuario.setDescripcion(registroRequest.getDescripcion());

        if (registroRequest.getUserType().equals(1)) {
            usuario.setRoles(Arrays.asList(new Role(2L, "ROLE_DEVELOPER")));
        } else if (registroRequest.getUserType().equals(0)) {
            usuario.setRoles(Arrays.asList(new Role(3L, "ROLE_COMPANY")));
        } else {
            throw new IllegalArgumentException("Tipo de usuario inválido");
        }

        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setEstado(true);

        usuario = usuarioRepository.save(usuario);

        if (registroRequest.getUserType().equals(1)) { // Desarrollador
            PerfilDesarrollador desarrollador = new PerfilDesarrollador();
            desarrollador.setUsuario(usuario);
            List<Habilidad> habilidades = registroRequest.getHabilidades().stream()
                .map(id -> habilidadRepository.findById(id).orElseThrow(() -> new RuntimeException("Habilidad no encontrada: " + id)))
                .collect(Collectors.toList());
            desarrollador.setHabilidades(habilidades);
            desarrollador.setExperiencia(registroRequest.getExperiencia());
            desarrollador.setPortafolioURL(registroRequest.getPortafolioURL());
            desarrollador = desarrolladorRepository.save(desarrollador);

        } else if (registroRequest.getUserType() == 0) { // Compañía
            PerfilCompania compania = new PerfilCompania();
            compania.setUsuario(usuario);
            compania.setNombreCompania(registroRequest.getNombreCompania());
            if (registroRequest.getIndustria() != null) {
                compania.setIndustria(industriaRepository.findById(registroRequest.getIndustria()).orElse(null));
            }
            compania.setWebsite(registroRequest.getWebsite());
            compania = companiaRepository.save(compania);
        }
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        usuario.setEstado(false); // Cambiar el estado a inactivo en lugar de eliminar
        usuarioRepository.save(usuario);
    }

    private static class ResetCodeInfo {
        String code;
        long expiresAt;

        ResetCodeInfo(String code, long expiresAt) {
            this.code = code;
            this.expiresAt = expiresAt;
        }
    }

    private Map<String, ResetCodeInfo> resetCodes = new HashMap<>();

    @Override
    public boolean sendResetCode(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (!usuario.isPresent()) {
            return false;
        }
        // Generar código de 6 dígitos
        String code = String.format("%06d", new Random().nextInt(999999));
        long expiresAt = System.currentTimeMillis() + 10 * 60 * 1000; // 10 minutos
        resetCodes.put(email, new ResetCodeInfo(code, expiresAt));

        Notification notification = new Notification();
        notification.setEmail(email);
        notification.setTitle("Código de recuperación de contraseña");
        notification.setMessage("Tu código de recuperación es: " + code + "\nEste código expirará en 10 minutos.");
        notificationService.createNotification(notification);

        return true;
    }

    @Override
    public boolean verifyResetCode(String email, String code) {
        ResetCodeInfo info = resetCodes.get(email);
        if (info == null)
            return false;
        if (!info.code.equals(code))
            return false;
        if (System.currentTimeMillis() > info.expiresAt) {
            resetCodes.remove(email); // Eliminar código expirado
            return false;
        }
        return true;
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
