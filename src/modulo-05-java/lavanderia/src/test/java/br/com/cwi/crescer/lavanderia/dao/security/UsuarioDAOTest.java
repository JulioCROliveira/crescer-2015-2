package br.com.cwi.crescer.lavanderia.dao.security;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.security.Usuario;

public class UsuarioDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Test
    public void deveBuscarUsuariosComUsernameUser() throws Exception {
        Usuario usuario = usuarioDAO.findByUsername("user");
        Assert.assertNotNull(usuario);
        Assert.assertNotNull(usuario.getRoles());
    }

    /*
     * Testes a implmentar
     * @Test
     * public void deveBuscarRoleDeUsuarioUser() throws Exception {
     * List<Authorities> usuarioRoles = usuarioDAO.findByUsername("user").getRoles();
     * Assert.assertFalse(usuarioRoles.isEmpty());
     * for (Authorities role : usuarioRoles) {
     * Assert.assertTrue("ROLE_USER".equals(role.getAuthority()));
     * }
     * }
     * @Test
     * public void deveBuscarRoleDeUsuarioAdmin() throws Exception {
     * List<Authorities> usuarioRoles = usuarioDAO.findByUsername("admin").getRoles();
     * Assert.assertFalse(usuarioRoles.isEmpty());
     * for (Authorities role : usuarioRoles) {
     * Assert.assertTrue("ROLE_ADMIN".equals(role.getAuthority()));
     * }
     * }
     */

    @Test
    public void deveBuscarUsuariosComUsernameIniciandoEmUse() throws Exception {
        List<Usuario> usuarios = usuarioDAO.searchByUsername("use");
        Assert.assertNotNull(usuarios);
        Assert.assertFalse(usuarios.isEmpty());

        for (Usuario usuario : usuarios) {
            Assert.assertTrue("use".equals(usuario.getUsername().substring(0, 3)));
        }
    }

    @Test
    public void deveBuscarTodos() throws Exception {
        List<Usuario> usuarios = usuarioDAO.listAll();
        Assert.assertNotNull(usuarios);
        Assert.assertFalse(usuarios.isEmpty());
    }

    @Test
    public void deveBuscarUsuariosAtivos() throws Exception {
        List<Usuario> usuarios = usuarioDAO.findWhereEnabledIs(true);
        Assert.assertNotNull(usuarios);
        Assert.assertFalse(usuarios.isEmpty());

        for (Usuario usuario : usuarios) {
            Assert.assertEquals(true, usuario.isEnabled());
        }
    }

}
