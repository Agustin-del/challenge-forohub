package com.aluracursos.challenge_forohub.infra.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<String> handleUsuarioNoEncontradoException(UsuarioNoEncontradoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(CursoNoEncontradoException.class)
    public ResponseEntity<String> handleCursoNoEncontradoException(CursoNoEncontradoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> handleViolacionDeIntegridad(SQLIntegrityConstraintViolationException e) {
        RestriccionDeIntegridadException ex = new RestriccionDeIntegridadException(e.getMessage());
        String mensaje = "Error de integridad de datos: " + ex.getMessage();
        return ResponseEntity.badRequest().body(mensaje);
    }

    @ExceptionHandler(TopicoNoEncontradoException.class)
    public ResponseEntity<String> handleTopicoNoEncontradoException(TopicoNoEncontradoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(DatosDeActualizacionInválidosException.class)
    public ResponseEntity<String> handleDatosDeActualizacionException(DatosDeActualizacionInválidosException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
