package com.mfaneli.usuarios.controller;

import com.mfaneli.usuarios.controller.dto.UsuarioMapper;
import com.mfaneli.usuarios.controller.dto.UsuarioRequest;
import com.mfaneli.usuarios.controller.dto.UsuarioResponse;
import com.mfaneli.usuarios.service.AtualizarUsuarioService;
import com.mfaneli.usuarios.service.CriarUsuarioService;
import com.mfaneli.usuarios.service.ListarUsuariosService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuariosController {
    private final CriarUsuarioService criarUsuarioService;
    private final ListarUsuariosService listarUsuariosService;
    private final ObterUsuarioPorIdService obterUsuarioPorIdService;
    private final AtualizarUsuarioService atualizarUsuarioService;
    private final UsuarioMapper usuarioMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse create(@RequestBody @Valid UsuarioRequest request) {
        return usuarioMapper.map(criarUsuarioService.executar(usuarioMapper.map(request)));
    }
    @GetMapping
    public List<UsuarioResponse> findAll() {
        return listarUsuariosService.executar().stream()
                .map(usuarioMapper::map)
                .toList();
    }
    @GetMapping("/{id}")
    public UsuarioResponse findById(@PathVariable Integer id) {
        return usuarioMapper.map(obterUsuarioPorIdService.executar(id));
    }
    @PutMapping("/{id}")
    public UsuarioResponse update(@PathVariable Integer id, @RequestBody @Valid UsuarioRequest request) {
        return usuarioMapper.map(atualizarUsuarioService.executar(usuarioMapper.map(request, id)));
    }
}
