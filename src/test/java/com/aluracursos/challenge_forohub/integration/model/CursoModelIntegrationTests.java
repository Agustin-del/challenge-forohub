//hice un quilombo con los tests

//package com.aluracursos.challenge_forohub.integration.model;
//
//import com.aluracursos.challenge_forohub.curso.Curso;
//import com.aluracursos.challenge_forohub.curso.CursoRepository;
//import com.aluracursos.challenge_forohub.curso.categoria.Categoria;
//import com.aluracursos.challenge_forohub.curso.categoria.CategoriaRepository;
//import com.aluracursos.challenge_forohub.mensaje.Mensaje;
//import com.aluracursos.challenge_forohub.topico.Topico;
//import com.aluracursos.challenge_forohub.topico.TopicoRepository;
//import com.aluracursos.challenge_forohub.usuario.Usuario;
//import jakarta.transaction.Transactional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
//public class CursoModelIntegrationTests {
//    @Autowired
//    private  CursoRepository cursoRepository;
//    @Autowired
//    private CategoriaRepository categoriaRepository;
//    @Autowired
//    private TopicoRepository topicoRepository;
//    private Categoria categoria;
//    private List<Topico> topicos = new ArrayList<>();
//    private Usuario usuario = new Usuario(null,"jose","jose","jose",null,null);
//    private Mensaje mensaje = new Mensaje(null,"This is the first message for topic 1",null,LocalDateTime.now().minusDays(1),false, null);
//
//    @BeforeEach
//    public void setUp() {
//        usuario.addMensaje(mensaje);
//        categoria = new Categoria(null, "Programación");
//        categoriaRepository.save(categoria);
//
//        Topico topico1 = new Topico(null,"Introduction to Java Programming", "Learn the basics of Java programming, including syntax, data types, and control structures.", LocalDateTime.now(),true,null, null, usuario);
//        Topico topico2 = new Topico(null,"Spring Framework Basics","Understand the core concepts of the Spring Framework, including dependency injection and configuration.",LocalDateTime.now().minusDays(1),true,null,null, usuario);
//        topico1.addMensaje(mensaje);
//        topico2.addMensaje(mensaje);
//        topicos.add(topico1);
//        topicos.add(topico2);
//    }
//
//    @Test
//    @Transactional
//    public void shouldPersistCursoWithCategoria () {
//        Curso curso = new Curso(null, "Java", categoria, topicos);
//        cursoRepository.save(curso);
//
//        Curso cursoGuardado = cursoRepository.getReferenceById(curso.getId());
//
//        assertEquals(cursoGuardado.getNombre(), "Java");
//        assertEquals(cursoGuardado.getCategoria(), categoria);
//    }
//
//    @Test
//    @Transactional
//    public void shouldAssociateMultipleCursosWithSameCategoria() {
//        Curso curso1 = new Curso(null, "Java", categoria, List.of(topicos.get(0)));
//        Curso curso2 = new Curso(null, "Spring", categoria, List.of(topicos.get(1)));
//        cursoRepository.save(curso1);
//        cursoRepository.save(curso2);
//
//        assertEquals(cursoRepository.getReferenceById(curso1.getId()).getCategoria(),
//                cursoRepository.getReferenceById(curso2.getId()).getCategoria());
//    }
//
//    @Test
//    @Transactional
//    public void shouldAddAtopicoInCascade() {
//        Curso curso = new Curso(null, "Java", categoria, topicos);
//        Topico topico = new Topico(null, "Introduction to Java Programming",
//                "Learn the basics of Java programming, including syntax, data types, and control structures.",
//                LocalDateTime.now(), true, null, List.of(mensaje), usuario);
//        curso.addTopico(topico);
//        cursoRepository.save(curso);
//
//        Curso cursoGuardado = cursoRepository.getReferenceById(curso.getId());
//        assertEquals(cursoGuardado.getTopicos().size(), 1);
//        assertEquals(cursoGuardado.getTopicos().get(0), topico);
//    }
//
//    @Test
//    @Transactional
//    public void shouldEliminateTopicInCascade() {
//        Curso curso = new Curso(null, "Java", categoria, topicos);
//        topicoRepository.saveAll(topicos);
//        cursoRepository.save(curso);
//        cursoRepository.delete(curso);
//
//        assert topicoRepository.findAll().isEmpty();
//    }
//
//}
