package com.desafio.desafio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.desafio.desafio.dto.ClienteDTO;
import com.desafio.desafio.dto.mapper.ClienteMapper;
import com.desafio.desafio.exception.RecordFoundException;
import com.desafio.desafio.exception.RecordNotFoundException;
import com.desafio.desafio.model.Cliente;
import com.desafio.desafio.repository.ClienteRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Service
@Validated
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;
    private final String text = "Registro não encontrado com o documento: ";

    public List<ClienteDTO> listar() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO listarPorId(@NotNull String documento) {
        return clienteRepository.findByDocumento(documento)
        .map(clienteMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(text + documento));
    }

    public ClienteDTO criar(@Valid ClienteDTO cliente) {

        Optional<Cliente> consulta = clienteRepository.findByDocumento(cliente.getDocumento());

        if(consulta.isPresent()) {
            if(cliente.getDocumento().equals(consulta.get().getDocumento())) {
                throw new RecordFoundException(cliente.getDocumento()); 
            }
        }

        return clienteMapper.toDTO(clienteRepository.save(clienteMapper.toEntity(cliente)));
    }

    public ClienteDTO atualizar(@NotNull String documento, @Valid ClienteDTO body) {
        return clienteRepository.findByDocumento(documento)
            .map(cliente -> {

                Cliente newBody = clienteMapper.toEntity(body);

                cliente.setNome(newBody.getNome());

                cliente.setDataNascimento(newBody.getDataNascimento());

                cliente.setContatos(newBody.getContatos());

                cliente.setEnderecos(newBody.getEnderecos());
                
                return clienteMapper.toDTO(clienteRepository.save(cliente));
            })
            .orElseThrow(() -> new RecordNotFoundException(text + documento));
    }

    public void deletar(@NotNull String documento) {

        clienteRepository.delete(
            clienteRepository.findByDocumento(documento).orElseThrow(() -> new RecordNotFoundException(text + documento))
        );
    }
    
}
