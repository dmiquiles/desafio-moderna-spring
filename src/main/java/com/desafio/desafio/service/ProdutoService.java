package com.desafio.desafio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.desafio.desafio.exception.RecordNotFoundException;
import com.desafio.desafio.model.Produto;
import com.desafio.desafio.repository.ProdutoRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Service
@Validated
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private final String text = "Registro não encontrado com o id: ";

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto listarPorId(@NotNull @Positive Long id) {
        return produtoRepository.findById(id)
        .map(produto -> produto)
        .orElseThrow(() -> new RecordNotFoundException(text + id));
    }

    public Produto criar(@Valid Produto produto){
        return produtoRepository.save(produto);
    }


    public Produto atualizar(@NotNull @Positive Long id, @Valid Produto produto) {
        return produtoRepository.findById(id)
        .map( p -> {

            p.setNome(produto.getNome());
            p.setPreco(produto.getPreco());
            p.setDescricao(produto.getDescricao());
            p.setCor(produto.getCor());

            p.setCategoria(produto.getCategoria());

            return produtoRepository.save(p);
        })
        .orElseThrow(() -> new RecordNotFoundException(text + id));
    }

    public void deletar(@NotNull @Positive Long id) {
        produtoRepository.delete(
            produtoRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(text + id))
        );
    }
    
}
