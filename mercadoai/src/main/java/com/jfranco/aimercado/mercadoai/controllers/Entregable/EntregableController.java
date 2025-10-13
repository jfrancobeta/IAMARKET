package com.jfranco.aimercado.mercadoai.controllers.Entregable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jfranco.aimercado.mercadoai.dto.Entregable.EntregableDTO;
import com.jfranco.aimercado.mercadoai.service.Entregable.IEntregableService;

@RestController
@RequestMapping("/entregables")
public class EntregableController {
    @Autowired
    private IEntregableService entregableService;

    @PostMapping("/{id}/upload")
    public ResponseEntity<?> uploadEntregable(
            @PathVariable("id") long entregableId,
            @RequestParam("file") MultipartFile file) {
        try {
            EntregableDTO dto = entregableService.uploadEntregable(entregableId, file);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al subir el archivo: " + e.getMessage());
        }
    }

    @PostMapping("/{id}/aprobar")
    public ResponseEntity<?> aprobarEntregable(@PathVariable("id") long entregableId) {
        try {
            EntregableDTO dto = entregableService.aprobarEntregable(entregableId);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al aprobar el entregable: " + e.getMessage());
        }
    }

    @PostMapping("/{id}/rechazar")
    public ResponseEntity<?> rechazarEntregable(@PathVariable("id") long entregableId) {
        try {
            EntregableDTO dto = entregableService.rechazarEntregable(entregableId);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al rechazar el entregable: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadEntregable(@PathVariable("id") long entregableId) {
        try {
            Resource resource = entregableService.getEntregableFile(entregableId);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}