package com.aluracursos.challenge_forohub.controllers;

import com.aluracursos.challenge_forohub.dominio.topico.dtos.DatosRegistroTopico;
import com.aluracursos.challenge_forohub.services.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity crearTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        return ResponseEntity.ok(topicoService.crearTopico(datos));
    }
}
