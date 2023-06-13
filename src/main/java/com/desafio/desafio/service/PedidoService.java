package com.desafio.desafio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.desafio.desafio.model.Pedido;
import com.desafio.desafio.repository.PedidoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Validated
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public Pedido criar(@Valid Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    
}
