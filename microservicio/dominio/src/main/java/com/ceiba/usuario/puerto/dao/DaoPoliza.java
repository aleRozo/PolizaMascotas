package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoPoliza;

import java.util.List;

public interface DaoPoliza {

    /**
     * Permite listar polizas
     * @return las polizas
     */
    List<DtoPoliza> listar();
}
