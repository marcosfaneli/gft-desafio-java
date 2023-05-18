package com.mfaneli.usuarios.service;

import com.mfaneli.usuarios.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExcluirUsuarioService {
    private final UsuarioRepository usuarioRepository;
    public void executar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
