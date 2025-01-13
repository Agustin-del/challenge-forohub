package com.aluracursos.challenge_forohub.mensaje;

import com.aluracursos.challenge_forohub.topico.Topico;
import com.aluracursos.challenge_forohub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Mensaje {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String mensaje;
    @ManyToOne @JoinColumn(name = "topico_id") private Topico topico;
    private LocalDateTime fechaCreacion;
    private boolean solucion;
    @ManyToOne (fetch = FetchType.LAZY) @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
