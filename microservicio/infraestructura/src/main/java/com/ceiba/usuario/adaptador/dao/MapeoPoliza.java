package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoPoliza;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoPoliza implements RowMapper<DtoPoliza>, MapperResult {

    @Override
    public DtoPoliza mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombrePropietario = resultSet.getString("nombre_propietario");
        String telefonoPropietario = resultSet.getString("telefono_propietario");
        String nombreMascota = resultSet.getString("nombre_mascota");
        String tipoMascota = resultSet.getString("tipo_mascota");
        LocalDate fechaNacimientoMascota = extraerLocalDate(resultSet, "fecha_nacimiento_mascota");
        String pesoMascota = resultSet.getString("peso_mascota");
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
