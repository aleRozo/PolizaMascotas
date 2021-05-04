package com.ceiba.usuario.controlador;

import com.ceiba.usuario.consulta.ManejadorListarPolizas;
import com.ceiba.usuario.modelo.dto.DtoPoliza;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/polizas")
@Api(tags={"Controlador consulta poliza"})
public class ConsultaControladorPoliza {

    private final ManejadorListarPolizas manejadorListarPolizas;

    public ConsultaControladorPoliza(ManejadorListarPolizas manejadorListarPolizas) {
        this.manejadorListarPolizas = manejadorListarPolizas;
    }

    @GetMapping
    @ApiOperation("Listar Polizas")
    public List<DtoPoliza> listar() {
        System.out.println("-- controlador");
        return this.manejadorListarPolizas.ejecutar();
    }

}
