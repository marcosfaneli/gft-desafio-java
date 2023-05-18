package com.mfaneli.usuarios.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "usuarios")
@Getter
@Setter
@Builder
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
    @Builder.Default
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    public boolean atingiuMaioridade() {
        return dataNascimento.isBefore(LocalDate.now().minusYears(18));
    }

    public boolean dominioEmailPermitido() {
        return email.endsWith("@gmail.com") || email.endsWith("@hotmail.com") || email.endsWith("@yahoo.com") || email.endsWith("@outlook.com");
    }
}
