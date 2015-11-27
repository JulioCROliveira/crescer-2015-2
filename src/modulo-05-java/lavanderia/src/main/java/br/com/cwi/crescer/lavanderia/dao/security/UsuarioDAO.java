package br.com.cwi.crescer.lavanderia.dao.security;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.dao.AbstractDAO;
import br.com.cwi.crescer.lavanderia.domain.security.Usuario;

@Repository
public class UsuarioDAO extends AbstractDAO {

    public Usuario findByUsername(String username) {
        return em.find(Usuario.class, username);
    }

    public List<Usuario> listAll() {
        return em.createQuery("FROM Usuario", Usuario.class)
                .getResultList();
    }

    public List<Usuario> searchByUsername(String username) {
        return em.createQuery("FROM Usuario u WHERE u.username like :username", Usuario.class)
                .setParameter("username", username + "%")
                .getResultList();
    }

    public List<Usuario> findWhereEnabledIs(boolean situacao) {
        return em.createQuery("FROM Usuario u WHERE u.enabled = :situacao", Usuario.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }

    @Transactional
    public Usuario save(Usuario usuario) {
        em.persist(usuario);
        return usuario;
    }

    @Transactional
    public Usuario alter(Usuario usuario) {
        return em.merge(usuario);
    }

}
