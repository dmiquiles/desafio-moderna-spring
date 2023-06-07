package com.desafio.desafio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.desafio.desafio.dto.ClienteDTO;
import com.desafio.desafio.dto.mapper.ClienteMapper;
import com.desafio.desafio.exception.RecordNotFoundException;
import com.desafio.desafio.model.Cliente;
import com.desafio.desafio.repository.ClienteRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Service
@Validated
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    public List<ClienteDTO> listar() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO listarPorId(@NotNull @Positive Long id) {
        return clienteRepository.findById(id)
        .map(clienteMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public ClienteDTO criar(@Valid ClienteDTO cliente) {
        Cliente c = clienteMapper.toEntity(cliente);
        return clienteMapper.toDTO(clienteRepository.save(c));
    }

    public ClienteDTO atualizar(@NotNull @Positive Long id, @Valid ClienteDTO body) {
        return clienteRepository.findById(id)
            .map(cliente -> {

                Cliente newBody = clienteMapper.toEntity(body);

                cliente.setNome(newBody.getNome());
                cliente.setDocumento(newBody.getDocumento());
                cliente.setDataNascimento(newBody.getDataNascimento());

                cliente.setContatos(newBody.getContatos());

                cliente.setEnderecos(newBody.getEnderecos());
                
                return clienteMapper.toDTO(clienteRepository.save(cliente));
            })
            .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void deletar(@NotNull @Positive Long id) {

        clienteRepository.delete(
            clienteRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id))
        );
    }
    
}
