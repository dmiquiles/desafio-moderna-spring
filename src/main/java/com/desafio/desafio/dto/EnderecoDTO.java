package com.desafio.desafio.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
    @JsonIgnore Long id;
    String logradouro;
    String bairro;
    String numero;
    String cep;
    String uf;
    String cidade;
    String complemento;
    
}
