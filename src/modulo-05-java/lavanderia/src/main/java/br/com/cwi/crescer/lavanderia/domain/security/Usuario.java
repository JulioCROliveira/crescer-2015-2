package br.com.cwi.crescer.lavanderia.domain.security;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Usuario {

    @Id
    @Column(name = "username", length = 100)
    private String username;

    @Basic(optional = false)
    @Column(name = "password", length = 32)
    private String password;

    @Basic(optional = false)
    @Column(name = "enabled", columnDefinition = "number(1)")
    private boolean enabled;

    @OneToMany(mappedBy = "user")
    private List<Authorities> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authorities> getRoles() {
        return roles;
    }

    public void setRoles(List<Authorities> roles) {
        this.roles = roles;
    }

    public boolean Equals(Object obj) {
        if (obj instanceof Usuario) {
            Usuario usuario = (Usuario) obj;
            return usuario.getUsername() == this.getUsername() &&
                    usuario.getPassword() == this.getPassword() &&
                    usuario.getRoles() == this.getRoles();
        }

        return false;
    }
}
