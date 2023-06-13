package com.desafio.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.desafio.model.Cliente;
import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    public Optional<Cliente> findByDocumento(String documento);
}
