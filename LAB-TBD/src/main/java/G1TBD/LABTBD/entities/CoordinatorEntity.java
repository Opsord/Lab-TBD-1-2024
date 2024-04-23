package G1TBD.LABTBD.entities;

import G1TBD.LABTBD.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatorEntity {
//public class CoordinatorEntity implements UserDetails{

    private long idCoordinator;
    private String rut;
    private String email;
    private String name;
    private String lastName;
    private String password;
    private long idInstitution;
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
