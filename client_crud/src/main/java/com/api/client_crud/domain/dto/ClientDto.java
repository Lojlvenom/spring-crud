package com.api.client_crud.domain.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientDto {
    Long id;
    String nome;
    String cpf;
    String sexo;
    Date nascimento;
}
