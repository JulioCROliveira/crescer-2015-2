package br.com.cwi.crescer.lavanderia.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.security.Usuario;
import br.com.cwi.crescer.lavanderia.dto.UsuarioDTO;

public class UsuarioMapper {

    @Autowired
    public static Usuario getNewEntity(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setEnabled(dto.isEnabled());
        return entity;
    }

    public static UsuarioDTO toDTO(Usuario entity) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEnabled(entity.isEnabled());
        return dto;
    }

    public static Usuario merge(UsuarioDTO dto, Usuario entity) {
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setEnabled(dto.isEnabled());
        return entity;
    }

}
