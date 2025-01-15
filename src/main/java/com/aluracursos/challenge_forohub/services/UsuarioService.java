package com.aluracursos.challenge_forohub.services;

import com.aluracursos.challenge_forohub.dominio.topico.Topico;
import com.aluracursos.challenge_forohub.dominio.usuario.Usuario;
import com.aluracursos.challenge_forohub.dominio.usuario.UsuarioRepository;
import com.aluracursos.challenge_forohub.infra.exceptions.UsuarioNoEncontrado;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void addTopico(String usuario, Topico topico) {
        Usuario usuarioAActualizar = usuarioRepository.findByNombre(usuario);
        if(usuarioAActualizar != null) {
            usuarioAActualizar.addTopico(topico);
            usuarioRepository.save(usuarioAActualizar);
            return;
        }
        throw new UsuarioNoEncontrado("El usuario " + usuario + " no fue encontrado");
    }
}
