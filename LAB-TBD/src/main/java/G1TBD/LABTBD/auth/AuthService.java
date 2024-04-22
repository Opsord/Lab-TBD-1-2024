package G1TBD.LABTBD.auth;
/*
import G1TBD.LABTBD.entities.VoluntarioEntity;
import G1TBD.LABTBD.jwt.JwtService;
import G1TBD.LABTBD.repositories.VoluntarioRepository;
import G1TBD.LABTBD.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse loginVoluntario(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getRut(), loginRequest.getContrasena()));
        UserDetails user = voluntarioRepository.obtenerPorRut(loginRequest.getRut());
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse registerVoluntario(RegisterRequest registerRequest) {
        VoluntarioEntity voluntarioEntity = VoluntarioEntity.builder()
                .email(registerRequest.getEmail())
                .contrasena(passwordEncoder.encode(registerRequest.getContrasena()))
                .rut(registerRequest.getRut())
                .nombre(registerRequest.getNombre())
                .apellido(registerRequest.getApellido())
                .role(Role.VOLUNTARIO)
                .build();

        voluntarioRepository.crear(voluntarioEntity);

        return AuthResponse.builder()
                .token(jwtService.getToken(voluntarioEntity))
                .build();
    }

    public AuthResponse loginCoordinador(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getRut(), loginRequest.getContrasena()));
        UserDetails user = voluntarioRepository.obtenerPorRut(loginRequest.getRut());
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse registerCoordinador(RegisterRequest registerRequest) {
        VoluntarioEntity voluntarioEntity = VoluntarioEntity.builder()
                .email(registerRequest.getEmail())
                .contrasena(passwordEncoder.encode(registerRequest.getContrasena()))
                .rut(registerRequest.getRut())
                .nombre(registerRequest.getNombre())
                .apellido(registerRequest.getApellido())
                .role(Role.COORDINADOR)
                .build();

        voluntarioRepository.crear(voluntarioEntity);

        return AuthResponse.builder()
                .token(jwtService.getToken(voluntarioEntity))
                .build();
    }


}
        */