package br.com.cwi.crescer.lavanderia.domain.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(AuthoritiesID.class)
@Table(name = "authorities")
public class Authorities {

    @Id
    @ManyToOne()
    @JoinColumn(name = "username")
    private Usuario user;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "authority", length = 30)
    private Roles authority;

    public static enum Roles {
        ROLE_USER, ROLE_ADMIN
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Roles getAuthority() {
        return authority;
    }

    public void setAuthority(Roles authority) {
        this.authority = authority;
    }
}