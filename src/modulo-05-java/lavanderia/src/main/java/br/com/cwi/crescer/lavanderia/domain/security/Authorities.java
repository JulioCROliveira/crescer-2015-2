package br.com.cwi.crescer.lavanderia.domain.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cwi.crescer.lavanderia.domain.security.Authorities.AuthoritiesID;

@Entity
@IdClass(AuthoritiesID.class)
@Table(name = "authorities")
public class Authorities {

    public Authorities() {

    }
    public class AuthoritiesID implements Serializable {

        private static final long serialVersionUID = 1L;
        private Usuario user;
        private String authority;

        public AuthoritiesID() {

        }

        public Usuario getUser() {
            return user;
        }

        public void setUser(Usuario user) {
            this.user = user;
        }

        public String getAuthority() {
            return authority;
        }

        public void setAuthority(String authority) {
            this.authority = authority;
        }

        @Override
        public int hashCode() {
            return this.getUser().hashCode() + this.getAuthority().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof AuthoritiesID) {
                AuthoritiesID authoritiesID = (AuthoritiesID) obj;
                return authoritiesID.getUser() == this.getUser() &&
                        authoritiesID.getAuthority() == this.getAuthority();
            }

            return false;
        }
    }

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
