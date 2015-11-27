package br.com.cwi.crescer.lavanderia.dao.security;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.security.Authorities;
import br.com.cwi.crescer.lavanderia.domain.security.Usuario;

public class AuthoritiesDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private AuthoritiesDAO authoritiesDAO;

    @Test
    public void deveBuscarRolesUSER() throws Exception {
        List<Authorities> authorities = authoritiesDAO.searchByRole(Authorities.Roles.ROLE_USER);
        Assert.assertNotNull(authorities);
        Assert.assertFalse(authorities.isEmpty());

        for (Authorities authority : authorities) {
            Assert.assertTrue("ROLE_USER".equals(authority.getAuthority().toString()));
        }
    }

    @Test
    public void deveBuscarRolesADMIN() throws Exception {
        List<Authorities> authorities = authoritiesDAO.searchByRole(Authorities.Roles.ROLE_ADMIN);
        Assert.assertNotNull(authorities);
        Assert.assertFalse(authorities.isEmpty());

        for (Authorities authority : authorities) {
            Assert.assertTrue("ROLE_ADMIN".equals(authority.getAuthority().toString()));
        }
    }

    @Test
    public void deveBuscarAuthorityComUsuario() throws Exception {
        Authorities busca = new Authorities();
        Usuario user = new Usuario();
        user.setUsername("admin");
        busca.setAuthority(Authorities.Roles.ROLE_ADMIN);
        busca.setUser(user);
        Authorities authority = authoritiesDAO.findByAuthority(busca);
        Assert.assertNotNull(authority);
        Assert.assertEquals(user.getUsername(), authority.getUser().getUsername());
    }

    @Test
    public void deveBuscarAuthoritiesPorUsername() throws Exception {
        List<Authorities> authorities = authoritiesDAO.searchByUsername("user");
        Assert.assertNotNull(authorities);
        Assert.assertFalse(authorities.isEmpty());

        for (Authorities authority : authorities) {
            Assert.assertTrue("user".equals(authority.getUser().getUsername()));
        }
    }

}
