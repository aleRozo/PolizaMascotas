package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoPoliza;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoPoliza;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPolizas {

    private final DaoPoliza daoPoliza;

    public ManejadorListarPolizas(DaoPoliza daoPoliza){
        this.daoPoliza = daoPoliza;
    }

    public List<DtoPoliza> ejecutar(){
        System.out.println("-- Manejador");
        return this.daoPoliza.listar();

    }
}
