package com.desafio.desafio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(length = 100, nullable = false)
    private String logradouro;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 5, nullable = false)
    private String numero;

    @Column(length = 15, nullable = false)
    private String cep;

    @Column(length = 3, nullable = false)
    private String uf;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 100, nullable = true)
    private String complemento;
}
