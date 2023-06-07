package com.desafio.desafio.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO {
    @JsonIgnore Long id;
    String ddd;
    String phone;
}
