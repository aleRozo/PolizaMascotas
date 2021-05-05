package com.ceiba.poliza.consulta;

import com.ceiba.poliza.modelo.dto.DtoPoliza;
import com.ceiba.poliza.puerto.dao.DaoPoliza;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPolizas {

    private final DaoPoliza daoPoliza;

    public ManejadorListarPolizas(DaoPoliza daoPoliza){
        this.daoPoliza = daoPoliza;
    }

    public List<DtoPoliza> ejecutar(){
        return this.daoPoliza.listar();
    }
}
