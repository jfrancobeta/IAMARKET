package com.jfranco.aimercado.mercadoai.mapper.Payment;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import com.jfranco.aimercado.mercadoai.dto.Payment.PaymentResponseDTO;
import com.jfranco.aimercado.mercadoai.mapper.Propuesta.PropuestaMapper;
import com.jfranco.aimercado.mercadoai.mapper.Solucion.SolucionMapper;
import com.jfranco.aimercado.mercadoai.model.Payment.Payment;

@Mapper(componentModel = "spring", uses = {SolucionMapper.class, PropuestaMapper.class})
public interface PaymentMapper {

    @Mapping(target = "initPoint", ignore = true)
    PaymentResponseDTO toDTO(Payment payment);

    List<PaymentResponseDTO> toDTO(List<Payment> payments);

    default Page<PaymentResponseDTO> toDTO(Page<Payment> payments) {
        return payments.map(this::toDTO);
    }
    
}
