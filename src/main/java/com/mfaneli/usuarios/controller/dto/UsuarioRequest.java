package com.mfaneli.usuarios.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class UsuarioRequest {
    @NotNull
    private String nome;
    @Email
    private String email;
    @NotNull
    private String endereco;
    @NotNull
    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;
    private List<String> habilidades;
}
