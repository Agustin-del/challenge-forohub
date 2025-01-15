package com.aluracursos.challenge_forohub.infra.exceptions;

public class RestriccionDeIntegridadException extends RuntimeException {
    public RestriccionDeIntegridadException(String message) {
        super(message);
    }
}
