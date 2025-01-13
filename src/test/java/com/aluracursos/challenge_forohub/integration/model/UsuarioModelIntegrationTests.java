//package com.aluracursos.challenge_forohub.integration.model;
//
//import com.aluracursos.challenge_forohub.curso.Curso;
//import com.aluracursos.challenge_forohub.mensaje.Mensaje;
//import com.aluracursos.challenge_forohub.mensaje.MensajeRepository;
//import com.aluracursos.challenge_forohub.topico.Topico;
//import com.aluracursos.challenge_forohub.topico.TopicoRepository;
//import com.aluracursos.challenge_forohub.usuario.Usuario;
//import com.aluracursos.challenge_forohub.usuario.UsuarioRepository;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
//public class UsuarioModelIntegrationTests {
//    @Autowired private UsuarioRepository usuarioRepository;
//    @Autowired private MensajeRepository mensajeRepository;
//    @Autowired private TopicoRepository topicoRepository;
//    private Mensaje mensaje;
//    private Topico topico;
//    private Curso curso;
//    @BeforeEach
//    public void setUp() {
//        curso = new Curso();
//        mensaje = new Mensaje(null, "Mensaje", null, LocalDateTime.now(), false, null);
//        topico = new Topico(null, "Titulo", "Mensaje", LocalDateTime.now(), true, curso, List.of(), null);
//        topico.addMensaje(mensaje);
//    }
//
//    @Test  @Transactional
//    public void shouldPersistMensajeInCascade() {
//        Usuario usuario = new Usuario(null, "jose", "jose", "jose", null, null);
//        usuario.addMensaje(mensaje);
//        usuario.addTopico(topico);
//        usuarioRepository.save(usuario);
//
//        Usuario usuarioGuardado = usuarioRepository.getReferenceById(usuario.getId());
//
//        assertThat(usuarioGuardado.getMensajes().size()).isEqualTo(1);
//        assertThat(usuarioGuardado.getMensajes().get(0)).isEqualTo(mensaje);
//    }
//
//    @Test  @Transactional
//    public void shouldPersistTopicoInCascade() {
//        Usuario usuario = new Usuario(null, "jose", "jose", "jose", null, null);
//        usuario.addTopico(topico);
//        usuario.addMensaje(mensaje);
//        usuarioRepository.save(usuario);
//
//        Usuario usuarioGuardado = usuarioRepository.getReferenceById(usuario.getId());
//
//        assertThat(usuarioGuardado.getTopicos().size()).isEqualTo(1);
//        assertThat(usuarioGuardado.getTopicos().get(0)).isEqualTo(topico);
//    }
//
//    @Test  @Transactional
//    public void shouldDeleteMensajesInCascade() {
//        Usuario usuario = new Usuario(null, "jose", "jose", "jose", null, null);
//        usuario.addMensaje(mensaje);
//        usuario.addTopico(topico);
//        usuarioRepository.save(usuario);
//
//        usuarioRepository.delete(usuario);
//
//        assertThat(usuarioRepository.findAll().size()).isEqualTo(0);
//        assertThat(mensajeRepository.findAll().size()).isEqualTo(0);
//    }
//
//    @Test  @Transactional
//    public void shouldDeleteTopicossInCascade() {
//        Usuario usuario = new Usuario(null, "jose", "jose", "jose", null, null);
//        usuario.addMensaje(mensaje);
//        usuario.addTopico(topico);
//        usuarioRepository.save(usuario);
//
//        usuarioRepository.delete(usuario);
//
//        assertThat(usuarioRepository.findAll().size()).isEqualTo(0);
//        assertThat(topicoRepository.findAll().size()).isEqualTo(0);
//    }
//
//}
