package com.mfaneli.usuarios.service;

import com.mfaneli.usuarios.model.Usuario;
import com.mfaneli.usuarios.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListarUsuariosService {
    private final UsuarioRepository usuarioRepository;
    public List<Usuario> executar() {
        return usuarioRepository.findAll();
    }
}
