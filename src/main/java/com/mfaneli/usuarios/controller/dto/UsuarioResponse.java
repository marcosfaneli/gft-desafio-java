package com.mfaneli.usuarios.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UsuarioResponse {
    private Integer id;
    private String nome;
    private String email;
    private String endereco;
    @JsonProperty("data_nascimento")
    private String dataNascimento;
    private List<String> habilidades;
}
