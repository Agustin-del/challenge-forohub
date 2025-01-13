create table cursos(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    categoria_id bigint not null,
    primary key (id),
    foreign key (categoria_id) references categorias(id)
);