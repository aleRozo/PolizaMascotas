insert into poliza (
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
    )
values (
    :nombrePropietario,
    :telefonoPropietario,
    :nombreMascota,
    :tipoMascota,
    :fechaNacimientoMascota,
    :pesoMascota,
    :alturaMascota,
    :valorPoliza,
    :fechaInicio,
    :fechaTerminacion
    )