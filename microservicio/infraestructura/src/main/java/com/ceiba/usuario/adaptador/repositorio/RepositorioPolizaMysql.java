package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Poliza;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioPoliza;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPolizaMysql implements RepositorioPoliza {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="poliza", value="crear")
    private static String sqlCrear;
//
//    @SqlStatement(namespace="usuario", value="actualizar")
//    private static String sqlActualizar;
//
//    @SqlStatement(namespace="usuario", value="eliminar")
//    private static String sqlEliminar;
//
    @SqlStatement(namespace="poliza", value="existe")
    private static String sqlExiste;

//    @SqlStatement(namespace="usuario", value="existeExcluyendoId")
//    private static String sqlExisteExcluyendoId;

    public RepositorioPolizaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Poliza poliza) {
        return this.customNamedParameterJdbcTemplate.crear(poliza, sqlCrear);
    }
//
//    @Override
//    public void eliminar(Long id) {
//        MapSqlParameterSource paramSource = new MapSqlParameterSource();
//        paramSource.addValue("id", id);
//
//        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
//    }

    @Override
    public boolean existe(String nombrePropietario, String nombreMascota) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombrePropietario", nombrePropietario);
        paramSource.addValue("nombreMascota", nombreMascota);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }
//
//    @Override
//    public void actualizar(Usuario usuario) {
//        this.customNamedParameterJdbcTemplate.actualizar(usuario, sqlActualizar);
//    }
//
//    @Override
//    public boolean existeExcluyendoId(Long id, String nombre) {
//        MapSqlParameterSource paramSource = new MapSqlParameterSource();
//        paramSource.addValue("id", id);
//        paramSource.addValue("nombre", nombre);
//
//        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
//    }
}
