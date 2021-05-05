package com.ceiba.poliza.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.poliza.comando.ComandoPoliza;
import com.ceiba.poliza.comando.manejador.ManejadorCrearPoliza;
import com.ceiba.poliza.comando.manejador.ManejadorEliminarPoliza;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polizas")
@Api(tags = { "Controlador comando poliza"})
public class ComandoControladorPoliza {

    private final ManejadorEliminarPoliza manejadorEliminarPoliza;
    private final ManejadorCrearPoliza manejadorCrearPoliza;

    @Autowired
    public ComandoControladorPoliza(ManejadorCrearPoliza manejadorCrearPoliza, ManejadorEliminarPoliza manejadorEliminarPoliza) {
        this.manejadorCrearPoliza = manejadorCrearPoliza;
        this.manejadorEliminarPoliza = manejadorEliminarPoliza;
    }

    @PostMapping
    @ApiOperation("Crear Poliza")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPoliza comandoPoliza) {
        return manejadorCrearPoliza.ejecutar(comandoPoliza);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Poliza")
	public void eliminar(@PathVariable Long id) {
        manejadorEliminarPoliza.ejecutar(id);
	}
}
