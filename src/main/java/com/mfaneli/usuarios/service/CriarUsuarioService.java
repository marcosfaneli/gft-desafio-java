package com.mfaneli.usuarios.service;

import com.mfaneli.usuarios.model.Usuario;
import com.mfaneli.usuarios.repository.UsuarioRepository;
import com.mfaneli.usuarios.shared.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarUsuarioService {
    private final UsuarioRepository usuarioRepository;
    public Usuario executar(Usuario usuario) {
        if (!usuario.atingiuMaioridade()) {
            throw new BusinessException("Usuário não atingiu a maioridade");
        }
        if (!usuario.dominioEmailPermitido()){
            throw new BusinessException("Domínio de e-mail não permitido");
        }
        return usuarioRepository.save(usuario);
    }
}
