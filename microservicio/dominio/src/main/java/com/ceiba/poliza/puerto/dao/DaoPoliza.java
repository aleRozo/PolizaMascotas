package com.ceiba.poliza.puerto.dao;

import com.ceiba.poliza.modelo.dto.DtoPoliza;

import java.util.List;

public interface DaoPoliza {

    /**
     * Permite listar polizas
     * @return las polizas
     */
    List<DtoPoliza> listar();
}
