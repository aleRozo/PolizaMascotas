create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table poliza (
    id int(11) not null auto_increment,
    nombre_propietario varchar(100) not null,
    telefono_propietario varchar(10) not null,
    nombre_mascota varchar(50) not null,
    tipo_mascota varchar(50) not null,
    fecha_nacimiento_mascota date not null,
    peso_mascota varchar(10) not null,
    altura_mascota varchar(10) null,
    valor_poliza double not null,
    fecha_inicio datetime not null,
    fecha_terminacion datetime not null,
    primary key (id)
);