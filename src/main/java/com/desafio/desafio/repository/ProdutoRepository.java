package com.desafio.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.desafio.model.Categoria;
import com.desafio.desafio.model.Produto;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

 Optional<List<Produto>> findByCategoria(Categoria categoria);    
}
