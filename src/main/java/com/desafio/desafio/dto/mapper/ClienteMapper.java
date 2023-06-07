package com.desafio.desafio.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.desafio.desafio.dto.ClienteDTO;
import com.desafio.desafio.model.Cliente;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteMapper {

    private final ModelMapper mapper;
    
    public ClienteDTO toDTO(Cliente cliente) {

        return mapper.map(cliente, ClienteDTO.class);

    }

    public Cliente toEntity(ClienteDTO clienteDTO) {

        return mapper.map(clienteDTO, Cliente.class);
        
    }

}
