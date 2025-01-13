create table topicos (
  id bigint not null auto_increment,
  titulo varchar(100) not null unique,
  mensaje text not null,
  fecha_creacion datetime not null,
  status boolean not null,
  curso_id bigint not null,
  usuario_id bigint not null,
  primary key (id),
  foreign key (curso_id) references cursos(id),
  foreign key (usuario_id) references usuarios(id)
)
