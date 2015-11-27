package br.com.cwi.crescer.lavanderia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.security.UsuarioDAO;
import br.com.cwi.crescer.lavanderia.domain.security.Usuario;
import br.com.cwi.crescer.lavanderia.dto.UsuarioDTO;
import br.com.cwi.crescer.lavanderia.mapper.UsuarioMapper;

@Service
public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    @Autowired
    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listAll();
    }

    public UsuarioDTO buscarUsuarioPorUsername(String username) {
        Usuario usuario = usuarioDAO.findByUsername(username);
        UsuarioDTO dto = UsuarioMapper.toDTO(usuario);
        dto.setPassword(encryptPassword(dto.getPassword()));
        return dto;
    }

    private String encryptPassword(String password) {
        return new Md5PasswordEncoder().encodePassword(password, null);
    }

}
