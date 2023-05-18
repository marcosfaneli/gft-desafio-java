package com.mfaneli.usuarios.service;

import com.mfaneli.usuarios.model.Usuario;
import com.mfaneli.usuarios.repository.UsuarioRepository;
import com.mfaneli.usuarios.shared.exception.UsuarioNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class AtualizarUsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    private AtualizarUsuarioService atualizarUsuarioService;
    @BeforeEach
    void setUp() {
        openMocks(this);
        atualizarUsuarioService = new AtualizarUsuarioService(usuarioRepository);
    }
    @Test
    void deveAtualizarUsuario() {
        var idUsuario = 1;
        var nome = "Mauricio Alterado";
        var email = "m@gmail.com";
        var endereco = "Rua 1";
        var dataNascimento = LocalDate.of(1990, 1, 1);

        var usuario = Usuario.builder()
                .id(idUsuario)
                .nome(nome)
                .email(email)
                .endereco(endereco)
                .dataNascimento(dataNascimento)
                .build();

        var usuarioSalvo = Usuario.builder().id(1).build();

        when(usuarioRepository.findById(usuario.getId())).thenReturn(Optional.of(usuarioSalvo));
        when(usuarioRepository.save(usuario)).thenReturn(usuarioSalvo);

        var resultado = atualizarUsuarioService.executar(usuario);

        verify(usuarioRepository).findById(usuario.getId());
        verify(usuarioRepository).save(usuario);

        assertEquals(usuario.getId(), resultado.getId());
        assertEquals(usuario.getNome(), resultado.getNome());
        assertEquals(usuario.getEmail(), resultado.getEmail());
        assertEquals(usuario.getEndereco(), resultado.getEndereco());
        assertEquals(usuario.getDataNascimento(), resultado.getDataNascimento());
    }
    @Test
    void deveLancarExcecaoQuandoUsuarioNaoExistir() {
        var usuario = Usuario.builder().id(1).build();
        var excecaoEsperada = new UsuarioNaoEncontradoException(1);

        when(usuarioRepository.findById(usuario.getId())).thenReturn(Optional.empty());

        var excecao = assertThrows(RuntimeException.class, () -> atualizarUsuarioService.executar(usuario));

        verify(usuarioRepository).findById(usuario.getId());
        verify(usuarioRepository, never()).save(usuario);

        assertEquals(excecaoEsperada.getMessage(), excecao.getMessage());
    }
}
