package com.desafio.desafio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafio.dto.ClienteDTO;
import com.desafio.desafio.service.ClienteService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{documento}")
    public ClienteDTO listarPorId(@PathVariable @NotNull String documento) {
        return clienteService.listarPorId(documento);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ClienteDTO create(@RequestBody @Valid ClienteDTO client) {
        return clienteService.criar(client);
    }

    @PutMapping("/{documento}")
    public ClienteDTO update(@PathVariable @NotNull String documento, @RequestBody @Valid ClienteDTO body) {
        return clienteService.atualizar(documento, body);
    }
    
    @DeleteMapping("/{documento}")
    public void delete(@PathVariable @NotNull String documento) {
        clienteService.deletar(documento);
    }
}
