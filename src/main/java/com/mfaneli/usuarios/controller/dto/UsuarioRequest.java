package com.mfaneli.usuarios.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.util.List;

@Getter
public class UsuarioRequest {
    @NotBlank
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "O nome deve conter apenas letras")
    private String nome;
    @Email(message = "O email deve ser válido")
    private String email;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9\\s]+", message = "O endereço deve conter apenas letras e números")
    private String endereco;
    @NotNull
    @JsonProperty("data_nascimento")
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "A data de nascimento deve estar no formato dd/MM/yyyy")
    private String dataNascimento;
    @NotNull
    @Size(min = 1)
    private List<String> habilidades;
}
