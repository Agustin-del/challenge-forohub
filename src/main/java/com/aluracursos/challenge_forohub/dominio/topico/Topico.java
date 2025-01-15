package com.aluracursos.challenge_forohub.dominio.topico;

import com.aluracursos.challenge_forohub.dominio.curso.Curso;
import com.aluracursos.challenge_forohub.dominio.mensaje.Mensaje;
import com.aluracursos.challenge_forohub.dominio.topico.dtos.DatosRegistroTopico;
import com.aluracursos.challenge_forohub.dominio.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "titulo")
public class Topico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private boolean status;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "curso_id")
    private Curso curso;
    @OneToMany(mappedBy = "topico", orphanRemoval = true)
    private List<Mensaje> mensajes = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void addMensaje(Mensaje mensaje) {
        mensaje.setTopico(this);
        mensajes.add(mensaje);
    }

    public Topico (DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = true;
    }
}
