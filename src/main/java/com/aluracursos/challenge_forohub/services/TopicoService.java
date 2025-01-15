    package com.aluracursos.challenge_forohub.services;

    import com.aluracursos.challenge_forohub.dominio.topico.Topico;
    import com.aluracursos.challenge_forohub.dominio.topico.TopicoRepository;
    import com.aluracursos.challenge_forohub.dominio.topico.dtos.DatosEnvíoTopico;
    import com.aluracursos.challenge_forohub.dominio.topico.dtos.DatosRegistroTopico;
    import org.springframework.stereotype.Service;

    @Service
    public class TopicoService {
        private final TopicoRepository topicoRepository;
        private final UsuarioService usuarioService;
        private final CursoService cursoService;

        public TopicoService(TopicoRepository topicoRepository, UsuarioService usuarioService, CursoService cursoService) {
            this.topicoRepository = topicoRepository;
            this.usuarioService = usuarioService;
            this.cursoService = cursoService;
        }

        public DatosEnvíoTopico crearTopico(DatosRegistroTopico datos) {
            Topico topico = new Topico(datos);
            cursoService.addTopico(datos.curso(), topico);
            usuarioService.addTopico(datos.usuario(), topico);
            topicoRepository.save(topico);
            return new DatosEnvíoTopico(topico);
        }
    }
