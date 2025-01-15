package com.aluracursos.challenge_forohub.services;

import com.aluracursos.challenge_forohub.dominio.curso.Curso;
import com.aluracursos.challenge_forohub.dominio.curso.CursoRepository;
import com.aluracursos.challenge_forohub.dominio.topico.Topico;
import com.aluracursos.challenge_forohub.infra.exceptions.CursoNoEncontradoException;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso obtenerCursoPorNombre(String nombre) {
        Curso curso = cursoRepository.findByNombre(nombre);
        if(curso == null) {
            throw new CursoNoEncontradoException("El curso " + nombre + " no fue encontrado");
        }
        return curso;
    }

    public void addTopico (String curso, Topico topico) {
        Curso cursoAActualizar = obtenerCursoPorNombre(curso);
        cursoAActualizar.addTopico(topico);
        cursoRepository.save(cursoAActualizar);
    }

    public void actualizarCurso(Topico topico, String nuevoNombre) {
        Curso curso = obtenerCursoPorNombre(nuevoNombre);
        topico.setCurso(curso);
    }
}
