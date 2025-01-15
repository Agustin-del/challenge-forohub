package com.aluracursos.challenge_forohub.dominio.topico.dtos;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String curso,
        @NotBlank String usuario
) {
}
