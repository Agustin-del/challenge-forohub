    package com.aluracursos.challenge_forohub.services;

    import com.aluracursos.challenge_forohub.dominio.topico.Topico;
    import com.aluracursos.challenge_forohub.dominio.topico.TopicoRepository;
    import com.aluracursos.challenge_forohub.dominio.topico.dtos.DatosActualizacionTopico;
    import com.aluracursos.challenge_forohub.dominio.topico.dtos.DatosEnvíoTopico;
    import com.aluracursos.challenge_forohub.dominio.topico.dtos.DatosRegistroTopico;
    import com.aluracursos.challenge_forohub.infra.exceptions.DatosDeActualizacionInválidosException;
    import com.aluracursos.challenge_forohub.infra.exceptions.TopicoNoEncontradoException;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
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

        public Page<DatosEnvíoTopico> listarTopicos(Pageable page, String curso, Integer año){
            Page<Topico> topicos = topicoRepository.findByCursoNombreAndAño(page, curso, año);
            return topicos.map(DatosEnvíoTopico::new);
        }

        public Page<DatosEnvíoTopico> listarTopicos(Pageable page, String curso){
            Page<Topico> topicos = topicoRepository.findByCursoNombre(page, curso);
            return topicos.map(DatosEnvíoTopico::new);
        }

        public Page<DatosEnvíoTopico> listarTopicos(Pageable page, Integer año){
            Page<Topico> topicos = topicoRepository.findByAño(page, año);
            return topicos.map(DatosEnvíoTopico::new);
        }

        public Page<DatosEnvíoTopico> listarTopicos(Pageable page) {
            Page<Topico> topicos = topicoRepository.findAll(page);
            return topicos.map(DatosEnvíoTopico::new);
        }

        public DatosEnvíoTopico obtenerTopicoEspecifico(Long id) {
            Topico topico = topicoRepository.getReferenceById(id);
            if(topico != null) {
                return new DatosEnvíoTopico(topico);
            }
            throw new TopicoNoEncontradoException("El topico con id " + id + " no fue encontrado");
        }

        public DatosEnvíoTopico actualizarTopico(Long id, DatosActualizacionTopico datos) {
            Topico topico = topicoRepository.findById(id).orElse(null);
            if(topico == null){
                throw new TopicoNoEncontradoException("El topico con id " + id + " no fue encontrado");
            }
            if(datos.mensaje() == null && datos.titulo() == null && datos.curso() == null) {
                throw new DatosDeActualizacionInválidosException("Los datos de actualización no pueden ser nulos");
            }
            if(datos.titulo() != null) {
                topico.setTitulo(datos.titulo());
            }
            if (datos.mensaje() != null) {
                topico.setMensaje(datos.mensaje());
            }
            if (datos.curso() != null) {
                cursoService.actualizarCurso(topico, datos.curso());
            }
            return new DatosEnvíoTopico(topico);
        }

        public void borrarTopico(Long id) {
            Topico topico = topicoRepository.findById(id).orElse(null);
            if(topico != null) {
                topicoRepository.delete(topico);
            } else {
                throw new TopicoNoEncontradoException("El topico con id " + id + " no fue encontrado");
            }
        }
    }
