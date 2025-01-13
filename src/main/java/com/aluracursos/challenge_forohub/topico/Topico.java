package com.aluracursos.challenge_forohub.topico;

import com.aluracursos.challenge_forohub.curso.Curso;
import com.aluracursos.challenge_forohub.mensaje.Mensaje;
import com.aluracursos.challenge_forohub.usuario.Usuario;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private boolean status;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "curso_id")
    private Curso curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mensaje> mensajes = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void addMensaje(Mensaje mensaje) {
        mensaje.setTopico(this);
        mensajes.add(mensaje);
    }
}
