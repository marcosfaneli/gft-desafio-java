package com.mfaneli.usuarios.controller;

import com.mfaneli.usuarios.controller.dto.UsuarioMapper;
import com.mfaneli.usuarios.controller.dto.UsuarioRequest;
import com.mfaneli.usuarios.controller.dto.UsuarioResponse;
import com.mfaneli.usuarios.service.CriarUsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuariosController {
    private final CriarUsuarioService criarUsuarioService;
    private final UsuarioMapper usuarioMapper;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse create(@RequestBody @Valid UsuarioRequest request) {
        return usuarioMapper.map(criarUsuarioService.executar(usuarioMapper.map(request)));
    }
}
