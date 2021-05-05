package com.ceiba.poliza.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.poliza.modelo.entidad.Poliza;
import com.ceiba.poliza.puerto.repositorio.RepositorioPoliza;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPolizaMysql implements RepositorioPoliza {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="poliza", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="poliza", value="eliminar")
    private static String sqlEliminar;
//
    @SqlStatement(namespace="poliza", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="poliza", value="existeId")
    private static String sqlExisteId;

    public RepositorioPolizaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Poliza poliza) {
        return this.customNamedParameterJdbcTemplate.crear(poliza, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombrePropietario, String nombreMascota) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombrePropietario", nombrePropietario);
        paramSource.addValue("nombreMascota", nombreMascota);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existeId(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteId,paramSource, Boolean.class);
    }
}
