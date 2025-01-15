package com.aluracursos.challenge_forohub.dominio.topico.dtos;

import com.aluracursos.challenge_forohub.dominio.topico.Topico;

import java.time.LocalDateTime;

public record DatosEnvíoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        boolean status,
        String usuario,
        String curso
) {
    public DatosEnvíoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.isStatus(), topico.getUsuario().getNombre(), topico.getCurso().getNombre());
    }
}
