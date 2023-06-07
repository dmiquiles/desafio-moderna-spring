package com.desafio.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.desafio.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    
}
