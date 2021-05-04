package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoPoliza;
import com.ceiba.usuario.comando.manejador.ManejadorCrearPoliza;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polizas")
@Api(tags = { "Controlador comando poliza"})
public class ComandoControladorPoliza {

//    private final ManejadorCrearUsuario manejadorCrearUsuario;
//	private final ManejadorEliminarUsuario manejadorEliminarUsuario;
//	private final ManejadorActualizarUsuario manejadorActualizarUsuario;
    private final ManejadorCrearPoliza manejadorCrearPoliza;
    @Autowired
    public ComandoControladorPoliza(ManejadorCrearPoliza manejadorCrearPoliza) {
        this.manejadorCrearPoliza = manejadorCrearPoliza;
    }

    @PostMapping
    @ApiOperation("Crear poliza")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPoliza comandoPoliza) {
        return manejadorCrearPoliza.ejecutar(comandoPoliza);
    }
//
//    @DeleteMapping(value="/{id}")
//	@ApiOperation("Eliminar Usuario")
//	public void eliminar(@PathVariable Long id) {
//		manejadorEliminarUsuario.ejecutar(id);
//	}
//
//	@PutMapping(value="/{id}")
//	@ApiOperation("Actualizar Usuario")
//	public void actualizar(@RequestBody ComandoUsuario comandoUsuario,@PathVariable Long id) {
//		comandoUsuario.setId(id);
//		manejadorActualizarUsuario.ejecutar(comandoUsuario);
//	}
}
