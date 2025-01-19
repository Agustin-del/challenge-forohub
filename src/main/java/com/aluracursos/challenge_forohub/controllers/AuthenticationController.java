package com.aluracursos.challenge_forohub.controllers;

import com.aluracursos.challenge_forohub.dominio.usuario.dtos.DatosLogin;
import com.aluracursos.challenge_forohub.services.security.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody DatosLogin datos) {
        String token = authenticationService.login(datos);
        return ResponseEntity.ok(token);
    }

}
