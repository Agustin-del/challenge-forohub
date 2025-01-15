package com.aluracursos.challenge_forohub.dominio.topico;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAll(Pageable page);
    Page<Topico> findByCursoNombre(Pageable page, String curso);
    @Query("SELECT t FROM Topico t WHERE t.curso.nombre = :curso AND YEAR(t.fechaCreacion)=:año")
    Page<Topico> findByCursoNombreAndAño(Pageable page, String curso, Integer año);
    @Query("SELECT t FROM Topico t WHERE YEAR(t.fechaCreacion) = :año")
    Page<Topico> findByAño(Pageable page, Integer año);
}
