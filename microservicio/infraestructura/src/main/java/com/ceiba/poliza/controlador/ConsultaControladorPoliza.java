package com.ceiba.poliza.controlador;

import com.ceiba.poliza.consulta.ManejadorListarPolizas;
import com.ceiba.poliza.modelo.dto.DtoPoliza;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/polizas")
@CrossOrigin(origins = "*")
@Api(tags={"Controlador consulta poliza"})
public class ConsultaControladorPoliza {

    private final ManejadorListarPolizas manejadorListarPolizas;

    public ConsultaControladorPoliza(ManejadorListarPolizas manejadorListarPolizas) {
        this.manejadorListarPolizas = manejadorListarPolizas;
    }

    @GetMapping
    @ApiOperation("Listar Polizas")
    public List<DtoPoliza> listar() {
        return this.manejadorListarPolizas.ejecutar();
    }

}
