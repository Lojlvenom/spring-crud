package com.api.client_crud.domain.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;

import org.hibernate.validator.constraints.Length;

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
    @Length(message = "CPF invalido", max = 12)
    String cpf;

    @Column(name = "sexo")
    @NotBlank(message = "Sexo é obrigatória")
    @Length(message = "Insira apenas o caracter inicial", max = 2)
    String sexo;

    @Column(name = "dataNascimento")
    @NotBlank(message = "Data de nascimento é obrigatória")
    Date dataNascimento;
}
