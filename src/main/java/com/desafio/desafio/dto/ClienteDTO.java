package com.desafio.desafio.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    Long id;
    @NotNull @NotBlank @Length(min = 5, max = 100) String nome;    
    @NotNull @NotBlank @Length(min = 5, max = 50) String documento;
    @NotBlank @NotNull String dataNascimento;
    List<ContatoDTO> contatos;
    List<EnderecoDTO> enderecos;
    
}
