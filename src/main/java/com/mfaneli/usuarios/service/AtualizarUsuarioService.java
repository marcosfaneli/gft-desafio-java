package com.mfaneli.usuarios.service;

import com.mfaneli.usuarios.model.Usuario;
import com.mfaneli.usuarios.repository.UsuarioRepository;
import com.mfaneli.usuarios.shared.exception.UsuarioNaoEncontradoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarUsuarioService {
    private final UsuarioRepository usuarioRepository;
    public Usuario executar(Usuario usuario) {
        var usuarioSalvo = usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario.getId()));

        usuarioSalvo.setNome(usuario.getNome());
        usuarioSalvo.setEmail(usuario.getEmail());
        usuarioSalvo.setEndereco(usuario.getEndereco());
        usuarioSalvo.setDataNascimento(usuario.getDataNascimento());
        usuarioSalvo.setHabilidades(usuario.getHabilidades());

        return usuarioRepository.save(usuario);
    }
}
