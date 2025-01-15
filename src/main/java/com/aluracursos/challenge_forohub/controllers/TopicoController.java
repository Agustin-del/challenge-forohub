package com.aluracursos.challenge_forohub.controllers;

import com.aluracursos.challenge_forohub.dominio.topico.dtos.DatosActualizacionTopico;
import com.aluracursos.challenge_forohub.dominio.topico.dtos.DatosEnvíoTopico;
import com.aluracursos.challenge_forohub.dominio.topico.dtos.DatosRegistroTopico;
import com.aluracursos.challenge_forohub.services.TopicoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity crearTopico(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriBuilder) {
        DatosEnvíoTopico topico = topicoService.crearTopico(datos);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.id()).toUri();
        return ResponseEntity.created(uri).body(topico);
    }

    @GetMapping
    public ResponseEntity listarTopicos(@PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC )
                                            Pageable page,
                                        @RequestParam(required = false) String curso,
                                        @RequestParam(required = false) Integer año
                                        ) {
        if(curso != null && año != null) {
            return ResponseEntity.ok(topicoService.listarTopicos(page, curso, año));
        } else if(curso != null) {
            return ResponseEntity.ok(topicoService.listarTopicos(page, curso));
        } else if(año != null) {
            return ResponseEntity.ok(topicoService.listarTopicos(page, año));
        }
        return ResponseEntity.ok(topicoService.listarTopicos(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerTopicoEspecifico(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.obtenerTopicoEspecifico(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizacionTopico datos) {

        return ResponseEntity.ok(topicoService.actualizarTopico(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity borrarTopico(@PathVariable Long id) {
        topicoService.borrarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
