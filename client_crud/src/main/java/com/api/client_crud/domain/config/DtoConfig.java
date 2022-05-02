package com.api.client_crud.domain.config;

import com.api.client_crud.domain.dto.ResponseDto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoConfig {
    
    @Bean
    public ResponseDto responseDto(){
        return new ResponseDto(); 
    }
}
