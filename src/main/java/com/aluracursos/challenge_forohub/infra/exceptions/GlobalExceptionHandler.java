package com.aluracursos.challenge_forohub.infra.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> handleUsuarioNoEncontradoException(UsuarioNoEncontrado e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleCursoNoEncontradoException(CursoNoEncontrado e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
