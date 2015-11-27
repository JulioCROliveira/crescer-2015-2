package br.com.cwi.crescer.lavanderia.domain.security;

import java.io.Serializable;

import br.com.cwi.crescer.lavanderia.domain.security.Authorities.Roles;

class AuthoritiesID implements Serializable {

    private static final long serialVersionUID = 1L;
    private Usuario user;
    private Roles authority;

    public AuthoritiesID(Usuario user, Roles authority) {
        this.user = user;
        this.authority = authority;
    }

    public AuthoritiesID() {

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

