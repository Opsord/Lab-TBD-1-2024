package com.example.demo.authentication.entities;

import com.example.demo.models.Voluntario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    private String rut;
    private String name;
    private String email;
    private String password;
    private static String ROLE = "VOLUNTARIO";

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(ROLE));
    }

    @Override
    public String getUsername() {
        return email;
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

    public static User voluntarioToUser(Voluntario voluntario){
        return new User(voluntario.getRut(), voluntario.getNombre(), voluntario.getCorreo(), voluntario.getContrasena());
    }

    public Map<String, Object> generateExtraClaims() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("rut", rut);
        claims.put("name", name);
        return claims;
    }
}

