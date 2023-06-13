package com.desafio.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desafio.model.Categoria;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
