package com.aluracursos.challenge_forohub.infra.exceptions;

public class CursoNoEncontradoException extends RuntimeException {
    public CursoNoEncontradoException(String message) {
        super(message);
    }
}
