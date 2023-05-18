package com.mfaneli.usuarios.service;

import com.mfaneli.usuarios.model.Usuario;
import com.mfaneli.usuarios.repository.UsuarioRepository;
import com.mfaneli.usuarios.shared.exception.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class CriarUsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    private CriarUsuarioService criarUsuarioService;

    @BeforeEach
    void setUp() {
        openMocks(this);
        criarUsuarioService = new CriarUsuarioService(usuarioRepository);
    }
    @Test
    void deveCriarUsuario() {
        var dataNascimento = LocalDate.of(1990, 1, 1);
        var email = "m@gmail.com";
        var endereco = "Rua 1";
        var nome = "Mauricio";

        Usuario usuarioSalvo = Usuario.builder()
                .nome(nome)
                .email(email)
                .endereco(endereco)
                .dataNascimento(dataNascimento)
                .id(1)
                .build();
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioSalvo);

        Usuario usuario = Usuario.builder().dataNascimento(dataNascimento).email(email).build();
        Usuario resultado = criarUsuarioService.executar(usuario);

        verify(usuarioRepository).save(usuario);

        assertEquals(usuarioSalvo, resultado);
    }
    @Test
    void deveLancarExcecaoQuandoUsuarioForMenorDeIdade() {
        Usuario usuario = Usuario.builder().dataNascimento(LocalDate.now()).build();
        var excecaoEsperada = new BusinessException("Usuário não atingiu a maioridade");

        var excecao = assertThrows(BusinessException.class, () -> criarUsuarioService.executar(usuario));

        verify(usuarioRepository, never()).save(usuario);

        assertEquals(excecaoEsperada.getMessage(), excecao.getMessage());
    }
    @Test
    void deveLancarExcecaoQuandoDominioDeEmailNaoForPermitido() {
        Usuario usuario = Usuario.builder()
                .dataNascimento(LocalDate.of(1990, 1, 1))
                .email("m@dominioerrado.com")
                .build();
        var excecaoEsperada = new BusinessException("Domínio de e-mail não permitido");

        var excecao = assertThrows(BusinessException.class, () -> criarUsuarioService.executar(usuario));

        verify(usuarioRepository, never()).save(usuario);

        assertEquals(excecaoEsperada.getMessage(), excecao.getMessage());
    }
}
