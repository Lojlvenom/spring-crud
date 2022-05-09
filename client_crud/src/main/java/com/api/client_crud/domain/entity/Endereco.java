package com.api.client_crud.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "endereco")
@Entity
@Data
@NoArgsConstructor

public class Endereco {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;

    @Column(name = "cep")
    @NotBlank(message = "CEP é obrigatório")
    String cep;

    
    @Column(name = "rua")
    @NotBlank(message = "Nome da rua é obrigatório")
    String rua;
    
    @Column(name = "bairro")
    @NotBlank(message = "Nome do bairro é obrigatório")
    String bairro;

    
    @Column(name = "numero")
    Long numero;

    
    @Column(name = "cidade")
    @NotBlank(message = "Nome da cidade é obrigatório")
    String cidade;

    
    @Column(name = "uf")
    @NotBlank(message = "Nome da unidade federativa é obrigatório")
    String uf;
    
    @OneToOne(mappedBy = "endereco")
    Client client;
}
