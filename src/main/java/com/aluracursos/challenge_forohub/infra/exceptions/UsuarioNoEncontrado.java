package com.aluracursos.challenge_forohub.infra.exceptions;

public class UsuarioNoEncontrado extends RuntimeException {
    public UsuarioNoEncontrado(String message) {
        super(message);
    }
}
