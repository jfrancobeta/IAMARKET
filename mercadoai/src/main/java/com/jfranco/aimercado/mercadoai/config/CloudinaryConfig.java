package com.jfranco.aimercado.mercadoai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

    @Bean
    Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dfjremvhf",
            "api_key", "644582679937874",
            "api_secret", "F2SQADAFXYTPpyKpT0xbMx8qC_g"
        ));
    }
    
}
