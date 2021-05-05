insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into poliza(
    nombre_propietario,
    telefono_propietario,
    nombre_mascota,
    tipo_mascota,
    fecha_nacimiento_mascota,
    peso_mascota,
    altura_mascota,
    valor_poliza,
    fecha_inicio,
    fecha_terminacion
) values (
    'Nombre Prueba',
    '12345',
    'Nombre Perrito',
    'Perro',
    '12-12-2020',
    2.0,
    '20',
    40000.0,
    now(),
    now()
);