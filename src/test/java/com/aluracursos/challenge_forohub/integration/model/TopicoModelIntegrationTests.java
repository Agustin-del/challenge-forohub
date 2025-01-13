//package com.aluracursos.challenge_forohub.integration.model;
//
//import com.aluracursos.challenge_forohub.curso.Curso;
//import com.aluracursos.challenge_forohub.curso.CursoRepository;
//import com.aluracursos.challenge_forohub.curso.categoria.Categoria;
//import com.aluracursos.challenge_forohub.mensaje.Mensaje;
//import com.aluracursos.challenge_forohub.mensaje.MensajeRepository;
//import com.aluracursos.challenge_forohub.topico.Topico;
//import com.aluracursos.challenge_forohub.topico.TopicoRepository;
//import com.aluracursos.challenge_forohub.usuario.Usuario;
//import jakarta.persistence.EntityNotFoundException;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
//public class TopicoModelIntegrationTests {
//    @Autowired
//    private  TopicoRepository topicoRepository;
//    @Autowired
//    private  CursoRepository cursoRepository;
//    @Autowired
//    private MensajeRepository mensajeRepository;
//    private  Curso curso;
//    private  List<Topico> topicos = new ArrayList<>();
//    private  List<Mensaje> mensajes = new ArrayList<>();
//    private Usuario usuario;
//
//    @BeforeEach
//    public void setUp() {
//        topicos.add(new Topico(
//                null,
//                "Introduction to Java Programming",
//                "Learn the basics of Java programming, including syntax, data types, and control structures.",
//                LocalDateTime.now(),
//                true,
//                null,
//                null,
//                null
//        ));
//
//        topicos.add(new Topico(
//                null,
//                "Spring Framework Basics",
//                "Understand the core concepts of the Spring Framework, including dependency injection and configuration.",
//                LocalDateTime.now().minusDays(1),
//                true,
//                null,
//                null,
//                null
//        ));
//        mensajes.add(new Mensaje(null, "This is the first message for topic 1", null, LocalDateTime.now().minusDays(1), false, null));
//        mensajes.add(new Mensaje(null, "This is the second message for topic 1", null, LocalDateTime.now(), true, null));
//        mensajes.add(new Mensaje(null, "This is the first message for topic 2", null, LocalDateTime.now().minusHours(2), false, null));
//
//        usuario = new Usuario(null, "jose", "jose", "jose", topicos, mensajes);
////        topicos.forEach(topico -> usuario.addTopico(topico));
////        mensajes.forEach(mensaje -> usuario.addMensaje(mensaje));
//        curso = new Curso(null, "Java", new Categoria(null, "Programacion"), null);
//        topicos.get(0).addMensaje(mensajes.get(0));
//        topicos.get(0).addMensaje(mensajes.get(1));
//        topicos.get(1).addMensaje(mensajes.get(2));
//        curso.addTopico(topicos.get(0));
//        curso.addTopico(topicos.get(1));
//    }
//
//    @Test
//    @Transactional
//    public void shouldFailWithEmptyTitle() {
//        topicoRepository.save(topicos.get(0));
//        Topico topico = new Topico(null, "Introduction to Java Programming",
//                "",
//                LocalDateTime.now(), true, curso, mensajes, usuario);
//
//        assertThrows(DataIntegrityViolationException.class, () -> topicoRepository.save(topico));
//    }
//
//    @Test
//    @Transactional
//    public void shouldFailWithEmptyMessage() {
//        topicoRepository.save(topicos.get(0));
//        Topico topico = new Topico(null, "",
//                "Learn the basics of Java programming, including syntax, data types, and control structures.",
//                LocalDateTime.now(), false, curso, mensajes, usuario);
//
//        assertThrows(DataIntegrityViolationException.class, () -> topicoRepository.save(topico));
//    }
//
//    @Test
//    @Transactional
//    public void shouldAddMensajeInCascade() {
//        Topico topico = new Topico(null, "Introduction to Java Programming",
//                "Learn the basics of Java programming, including syntax, data types, and control structures.",
//                LocalDateTime.now(), true, curso, null, usuario);
//        topico.addMensaje(mensajes.get(0));
//        topicoRepository.save(topico);
//
//        Topico topicoGuardado = topicoRepository.getReferenceById(topico.getId());
//        assertEquals(topicoGuardado.getMensajes().size(), 1);
//        assertEquals(topicoGuardado.getMensajes().get(0), mensajes.get(0));
//    }
//
//    @Test
//    @Transactional
//    public void shouldCascadeDeleteMensajesWhenTopicoIsDeleted() {
//        Topico topico = new Topico(null, "Introduction to Java Programming",
//                "Learn the basics of Java programming, including syntax, data types, and control structures.",
//                LocalDateTime.now(), true, curso, mensajes, usuario);
//
//        topicoRepository.save(topico);
//        topicoRepository.delete(topico);
//
//        assertEquals(topicoRepository.findAll().size(), 0);
//        assertThrows(EntityNotFoundException.class, () -> mensajeRepository.getReferenceById(mensajes.get(0).getId()));
//
//    }
//}
