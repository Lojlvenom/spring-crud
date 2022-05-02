package com.api.client_crud.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import java.util.Date;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
public class Client {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nome")
    @NotBlank(message = "Nome é obrigatório")
    @Length(message = "Nome com no máximo 50 caracteres", max = 50)
    String nome;

    @Column(name = "cpf")
    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "cpf invalido")
    String cpf;

    @Column(name = "sexo")
    @NotBlank(message = "Sexo é obrigatória")
    @Length(message = "Insira apenas o caracter inicial", max = 2)
    String sexo;

    @Column(name = "dataNascimento")
    @NotBlank(message = "Data de nascimento é obrigatória")
    Date dataNascimento;
}
