package G1TBD.LABTBD.entities;

import G1TBD.LABTBD.user.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

 */

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class CoordinadorEntity {
//public class CoordinadorEntity implements UserDetails{

    private long idCoordinador;
    private String rut;
    private String email;
    private String nombre;
    private String apellido;
    private String contrasena;
    private long idInstitucion;
    private Role role;

    /*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return rut;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

     */

}
