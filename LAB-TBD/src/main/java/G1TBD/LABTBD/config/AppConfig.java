package G1TBD.LABTBD.config;

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

import G1TBD.LABTBD.repositories.CoordinatorRepository;
import G1TBD.LABTBD.repositories.VolunteerRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final VolunteerRepository volunteerRepository;
    private final CoordinatorRepository coordinatorRepository;

    /*
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailService() {
        return username -> {
            VolunteerEntity voluntario = volunteerRepository.obtenerPorRut(username);
            if (voluntario != null) {
                return voluntario;
            }
            CoordinatorEntity coordinador = coordinatorRepository.obtenerPorRut(username);
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
