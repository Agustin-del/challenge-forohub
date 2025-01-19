package com.aluracursos.challenge_forohub.services.security;

import com.aluracursos.challenge_forohub.dominio.usuario.Usuario;
import com.aluracursos.challenge_forohub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UsuarioService usuarioService;

    @Autowired
    public UserDetailsServiceImpl (UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        Usuario usuario = usuarioService.obtenerUsuarioPorUsername(username);

        return User.withUsername(username)
                .password(usuario.getContraseña())
                .roles("USER")
                .build();
    }
}
