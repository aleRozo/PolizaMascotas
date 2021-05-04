package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoPoliza;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoPoliza implements RowMapper<DtoPoliza>, MapperResult {

    @Override
    public DtoPoliza mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombrePropietario = resultSet.getString("nombre_propietario");
        String telefonoPropietario = resultSet.getString("telefono_propietario");
        String nombreMascota = resultSet.getString("nombre_mascota");
        String tipoMascota = resultSet.getString("tipo_mascota");
        String fechaNacimientoMascota = resultSet.getString("fecha_nacimiento_mascota");
        double pesoMascota = resultSet.getDouble("peso_mascota");
        String alturaMascota = resultSet.getString("altura_mascota");
        BigDecimal valorPoliza = resultSet.getBigDecimal("valor_poliza");
        LocalDateTime fechaInicio = extraerLocalDateTime(resultSet, "fecha_inicio");
        LocalDateTime fechaTerminacion = extraerLocalDateTime(resultSet, "fecha_terminacion");

        return new DtoPoliza(
                id,
                nombrePropietario,
                telefonoPropietario,
                nombreMascota,
                tipoMascota,
                fechaNacimientoMascota,
                pesoMascota,
                alturaMascota,
                valorPoliza,
                fechaInicio,
                fechaTerminacion);
    }

}
