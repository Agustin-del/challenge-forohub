package com.aluracursos.challenge_forohub.curso;

import com.aluracursos.challenge_forohub.curso.categoria.Categoria;
import com.aluracursos.challenge_forohub.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topico> topicos = new ArrayList<>();

    public void addTopico(Topico topico) {
        topico.setCurso(this);
        topicos.add(topico);
    }
}
