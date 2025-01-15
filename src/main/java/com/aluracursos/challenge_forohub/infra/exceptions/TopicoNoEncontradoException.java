package com.aluracursos.challenge_forohub.infra.exceptions;

public class TopicoNoEncontradoException extends RuntimeException {
  public TopicoNoEncontradoException(String message) {
    super(message);
  }
}
