package G1TBD.LABTBD.config;

import G1TBD.LABTBD.entities.CoordinadorEntity;
import G1TBD.LABTBD.entities.VoluntarioEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

 */

import G1TBD.LABTBD.repositories.CoordinadorRepository;
import G1TBD.LABTBD.repositories.VoluntarioRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final VoluntarioRepository voluntarioRepository;
    private final CoordinadorRepository coordinadorRepository;

    /*
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailService() {
        return username -> {
            VoluntarioEntity voluntario = voluntarioRepository.obtenerPorRut(username);
            if (voluntario != null) {
                return voluntario;
            }
            CoordinadorEntity coordinador = coordinadorRepository.obtenerPorRut(username);
            if (coordinador != null) {
                return coordinador;
            }
            throw new UsernameNotFoundException("User not found");
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


     */


}
