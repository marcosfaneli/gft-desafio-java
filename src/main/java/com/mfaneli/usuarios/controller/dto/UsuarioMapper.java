package com.mfaneli.usuarios.controller.dto;

import com.mfaneli.usuarios.model.Habilidade;
import com.mfaneli.usuarios.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "habilidades", expression = "java(mapList(request.getHabilidades()))")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "email", source = "email", defaultExpression = "java(request.getEmail().toLowerCase())")
    @Mapping(target = "nome", source = "nome", defaultExpression = "java(request.getNome().toUpperCase())")
    @Mapping(target = "dataCriacao", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "dataAtualizacao", ignore = true)
    Usuario map(UsuarioRequest request);
    default Set<Habilidade> mapList(List<String> habilidades) {
        return habilidades.stream().map(h -> {
            var habilidade = new Habilidade();
            habilidade.setNome(h);
            return habilidade;
        }).collect(java.util.stream.Collectors.toSet());
    }
    @Mapping(target = "habilidades", expression = "java(mapList(usuario.getHabilidades()))")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "email", source = "email", defaultExpression = "java(usuario.getEmail().toLowerCase())")
    @Mapping(target = "nome", source = "nome", defaultExpression = "java(usuario.getNome().toUpperCase())")
    UsuarioResponse map(Usuario usuario);
    default List<String> mapList(Set<Habilidade> habilidades) {
        return habilidades.stream().map(Habilidade::getNome).collect(java.util.stream.Collectors.toList());
    }
}
