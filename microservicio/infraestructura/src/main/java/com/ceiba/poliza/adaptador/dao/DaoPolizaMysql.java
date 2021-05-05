package com.ceiba.poliza.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.poliza.modelo.dto.DtoPoliza;
import com.ceiba.poliza.puerto.dao.DaoPoliza;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPolizaMysql implements DaoPoliza {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "poliza", value="listar")
    private static String sqlListar;

    public DaoPolizaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPoliza> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPoliza());
    }
}
