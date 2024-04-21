package com.example.demo.authentication.controllers;

import com.example.demo.authentication.entities.AuthenticationResponse;
import com.example.demo.authentication.entities.LoginRequest;
import com.example.demo.authentication.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/voluntario-login/{correo}/{contrasena}")
    public ResponseEntity<AuthenticationResponse> login(@PathVariable String correo, @PathVariable String contrasena){
        LoginRequest request = new LoginRequest(correo,contrasena);
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
