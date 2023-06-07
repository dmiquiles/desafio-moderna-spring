package com.desafio.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.desafio.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
