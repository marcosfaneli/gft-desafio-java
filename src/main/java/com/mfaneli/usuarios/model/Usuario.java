package com.mfaneli.usuarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String endereco;
    private LocalDate dataNascimento;
    @OneToMany(mappedBy = "usuario")
    private Set<Habilidade> habilidades;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao = LocalDateTime.now();
}
