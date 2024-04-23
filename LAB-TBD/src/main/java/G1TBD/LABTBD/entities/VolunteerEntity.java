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
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerEntity {
//public class VolunteerEntity implements UserDetails {

    private long idVolunteer;
    private String rut;
    private String email;
    private String name;
    private String lastName;
    private int age;
    private boolean sex;
    private String password;
    private boolean availability;
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
