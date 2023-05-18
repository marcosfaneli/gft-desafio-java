package com.mfaneli.usuarios.service;

import com.mfaneli.usuarios.model.Usuario;
import com.mfaneli.usuarios.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarUsuarioService {
    private final UsuarioRepository usuarioRepository;
    public Usuario executar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
