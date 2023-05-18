package com.mfaneli.usuarios.service;

import com.mfaneli.usuarios.controller.ObterUsuarioPorIdService;
import com.mfaneli.usuarios.model.Usuario;
import com.mfaneli.usuarios.repository.UsuarioRepository;
import com.mfaneli.usuarios.shared.exception.UsuarioNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class ObterUsuarioPorIdServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    private ObterUsuarioPorIdService obterUsuarioPorIdService;
    @BeforeEach
    void setUp() {
        openMocks(this);
        obterUsuarioPorIdService = new ObterUsuarioPorIdService(usuarioRepository);
    }
    @Test
    void deveObterUsuarioPorId() {
        var idUsuario = 1;
        var usuario = Usuario.builder().id(idUsuario).build();
        when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.of(usuario));
        var usuarioObtido = obterUsuarioPorIdService.executar(idUsuario);

        verify(usuarioRepository).findById(idUsuario);

        assertEquals(usuario, usuarioObtido);
    }
    @Test
    void deveLancarExcecaoQuandoUsuarioNaoExistir() {
        var idUsuario = 1;
        when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.empty());
        var excecaoEsperada = new UsuarioNaoEncontradoException(idUsuario);
        var excecao = assertThrows(RuntimeException.class, () -> obterUsuarioPorIdService.executar(idUsuario));

        verify(usuarioRepository).findById(idUsuario);

        assertEquals(excecaoEsperada.getMessage(), excecao.getMessage());
    }
}
