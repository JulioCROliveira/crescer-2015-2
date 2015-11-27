package br.com.cwi.crescer.lavanderia.dao.security;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.dao.AbstractDAO;
import br.com.cwi.crescer.lavanderia.domain.security.Authorities;

@Repository
public class AuthoritiesDAO extends AbstractDAO {

    public Authorities findByAuthority(Authorities authority) {
        return em.createQuery("FROM Authorities a WHERE a.username = :username and "
                + "a.authority = :authority", Authorities.class)
                .setParameter("username", authority.getUser().getUsername())
                .setParameter("authority", authority.getAuthority())
                .getSingleResult();
    }

    public List<Authorities> searchByUsername(String username) {
        return em.createQuery("FROM Authorities a WHERE a.username = :username", Authorities.class)
                .setParameter("username", username + "%")
                .getResultList();
    }

    public List<Authorities> searchByRole(Authorities.Roles authority) {
        return em.createQuery("FROM Authorities a WHERE a.authority = :authority", Authorities.class)
                .setParameter("authority", authority)
                .getResultList();
    }

    @Transactional
    public Authorities grant(Authorities authority) {
        em.persist(authority);
        return authority;
    }

    @Transactional
    public void revoke(Authorities authority) {
        em.createQuery("DELETE FROM Authorities a WHERE a.username = :username and "
                + "a.authority = :authority", Authorities.class)
        .setParameter("username", authority.getUser().getUsername())
                .setParameter("authority", authority.getAuthority());
    }
}
