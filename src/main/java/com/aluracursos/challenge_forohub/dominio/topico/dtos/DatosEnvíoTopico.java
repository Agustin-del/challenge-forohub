package com.aluracursos.challenge_forohub.dominio.topico.dtos;

import com.aluracursos.challenge_forohub.dominio.topico.Topico;

import java.time.LocalDateTime;

public record DatosEnvíoTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        boolean status
) {
    public DatosEnvíoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.isStatus());
    }
}
