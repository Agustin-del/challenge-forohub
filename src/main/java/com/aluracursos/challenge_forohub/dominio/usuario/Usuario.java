package com.aluracursos.challenge_forohub.dominio.usuario;

import com.aluracursos.challenge_forohub.dominio.mensaje.Mensaje;
import com.aluracursos.challenge_forohub.dominio.topico.Topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contraseña;
    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    List<Topico> topicos = new ArrayList<>();
    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    List<Mensaje> mensajes = new ArrayList<>();

    public void addTopico(Topico topico) {
        topico.setUsuario(this);
        topicos.add(topico);
    }

    public void addMensaje(Mensaje mensaje) {
        mensaje.setUsuario(this);
        mensajes.add(mensaje);
    }
}
