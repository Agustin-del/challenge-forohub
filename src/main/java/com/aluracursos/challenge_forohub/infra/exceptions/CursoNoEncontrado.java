package com.aluracursos.challenge_forohub.infra.exceptions;

public class CursoNoEncontrado extends RuntimeException {
    public CursoNoEncontrado(String message) {
        super(message);
    }
}
