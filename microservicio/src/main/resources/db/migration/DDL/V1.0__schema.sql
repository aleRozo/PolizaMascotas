create table poliza (
    id int(11) not null auto_increment,
    nombre_propietario varchar(100) not null,
    telefono_propietario varchar(10) not null,
    nombre_mascota varchar(50) not null,
    tipo_mascota varchar(50) not null,
    fecha_nacimiento_mascota varchar(10) not null,
    peso_mascota double not null,
    altura_mascota varchar(10) null,
    valor_poliza double not null,
    fecha_inicio datetime not null,
    fecha_terminacion datetime not null,
    primary key (id)
);