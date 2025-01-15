package com.aluracursos.challenge_forohub.services;

import com.aluracursos.challenge_forohub.dominio.curso.Curso;
import com.aluracursos.challenge_forohub.dominio.curso.CursoRepository;
import com.aluracursos.challenge_forohub.dominio.topico.Topico;
import com.aluracursos.challenge_forohub.infra.exceptions.CursoNoEncontrado;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public void addTopico (String curso, Topico topico) {
        Curso cursoAActualizar = cursoRepository.findByNombre(curso);
        if(cursoAActualizar != null) {
            cursoAActualizar.addTopico(topico);
            cursoRepository.save(cursoAActualizar);
            return;
        }
        throw new CursoNoEncontrado("El curso " + curso + " no fue encontrado");
    }
}
