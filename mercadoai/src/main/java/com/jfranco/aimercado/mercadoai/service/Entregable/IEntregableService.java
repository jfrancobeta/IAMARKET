package com.jfranco.aimercado.mercadoai.service.Entregable;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.jfranco.aimercado.mercadoai.dto.Entregable.EntregableDTO;

public interface IEntregableService {
    EntregableDTO uploadEntregable(long entregableId, MultipartFile file);
    EntregableDTO aprobarEntregable(long entregableId);
    EntregableDTO rechazarEntregable(long entregableId);
    Resource getEntregableFile(long entregableId);
}
