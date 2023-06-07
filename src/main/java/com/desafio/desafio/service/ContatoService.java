package com.desafio.desafio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.desafio.model.Contato;
import com.desafio.desafio.repository.ContatoRepository;

@Service
public class ContatoService {

    private ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public List<Contato> listar() {
        return contatoRepository.findAll();
    }
    
}
