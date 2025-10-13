package com.jfranco.aimercado.mercadoai.service.Entregable;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jfranco.aimercado.mercadoai.dto.Entregable.EntregableDTO;
import com.jfranco.aimercado.mercadoai.mapper.Entregable.EntregableMapper;
import com.jfranco.aimercado.mercadoai.model.Entregable;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.repository.Entregas.EntregableRepository;
import com.jfranco.aimercado.mercadoai.repository.Estado.EstadoRepository;

@Service
public class EntregableService implements IEntregableService {

    @Autowired
    private EntregableMapper entregableMapper;

    @Autowired
    private EntregableRepository entregableRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    private final String UPLOAD_DIR = "uploads/";

    @Override
    public EntregableDTO uploadEntregable(long entregableId, MultipartFile file) {
        Entregable entregable = entregableRepository.findById(entregableId)
                .orElseThrow(() -> new RuntimeException("Entregable no encontrado"));

        String uploadPath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator;
        String fileName = entregable.getId() + "_" + file.getOriginalFilename();
        File dest = new File(uploadPath + fileName);

        dest.getParentFile().mkdirs();

        try {
            file.transferTo(dest);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el archivo", e);
        }

        entregable.setUrl("/" + UPLOAD_DIR + fileName);

        Estado pendiente = estadoRepository.findByNombre("Pendiente")
                .orElseThrow(() -> new RuntimeException("Estado 'Pendiente' no encontrado"));
        entregable.setEstado(pendiente);

        entregableRepository.save(entregable);
        return entregableMapper.toDTO(entregable);
    }

    @Override
    public EntregableDTO aprobarEntregable(long entregableId) {
        Entregable entregable = entregableRepository.findById(entregableId)
                .orElseThrow(() -> new RuntimeException("Entregable no encontrado"));

        Estado aprobado = estadoRepository.findByNombre("Aprobado")
                .orElseThrow(() -> new RuntimeException("Estado 'Aprobado' no encontrado"));
        entregable.setEstado(aprobado);

        entregableRepository.save(entregable);
        return entregableMapper.toDTO(entregable);
    }

    @Override
    public EntregableDTO rechazarEntregable(long entregableId) {
        Entregable entregable = entregableRepository.findById(entregableId)
                .orElseThrow(() -> new RuntimeException("Entregable no encontrado"));

        Estado rechazado = estadoRepository.findByNombre("Rechazado")
                .orElseThrow(() -> new RuntimeException("Estado 'Rechazado' no encontrado"));
        entregable.setEstado(rechazado);

        entregableRepository.save(entregable);
        return entregableMapper.toDTO(entregable);
    }

    @Override
    public Resource getEntregableFile(long entregableId) {
        Entregable entregable = entregableRepository.findById(entregableId)
                .orElseThrow(() -> new RuntimeException("Entregable no encontrado"));
        String filePath = System.getProperty("user.dir") + entregable.getUrl().replace("/", java.io.File.separator);
        try {
            Resource resource = new UrlResource(new java.io.File(filePath).toURI());
            if (!resource.exists()) {
                throw new RuntimeException("Archivo no encontrado");
            }
            return resource;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el archivo", e);
        }
    }
}
