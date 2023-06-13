package com.desafio.desafio.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
// @SQLDelete(sql = "UPDATE Cliente SET status = 'inativo' WHERE id = ?")
@Where(clause = "status = 'ativo'")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(length = 100, nullable = false)
    private String nome;

    @NotNull
    @NotBlank
    @Column(length = 15, nullable = false)
    private String documento;

    @NotBlank
    @NotNull
    @Column(length = 15, nullable = false)
    private String dataNascimento;

    @NotNull
    @Column(length = 10, nullable = false)
    private String status = "ativo";

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", nullable = false)
    private List<Contato> contatos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", nullable = false)
    private List<Endereco> enderecos = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pedido> pedidos = new ArrayList<>();

}
