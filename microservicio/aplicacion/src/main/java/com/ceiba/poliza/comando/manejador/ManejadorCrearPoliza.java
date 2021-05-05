package com.ceiba.poliza.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.poliza.comando.ComandoPoliza;
import com.ceiba.poliza.comando.fabrica.FabricaPoliza;
import com.ceiba.poliza.modelo.entidad.Poliza;
import com.ceiba.poliza.servicio.ServicioCrearPoliza;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPoliza implements ManejadorComandoRespuesta<ComandoPoliza, ComandoRespuesta<Long>> {

    private final FabricaPoliza fabricaPoliza;
    private final ServicioCrearPoliza servicioCrearPoliza;

    public ManejadorCrearPoliza(FabricaPoliza fabricaPoliza, ServicioCrearPoliza servicioCrearPoliza) {
        this.fabricaPoliza = fabricaPoliza;
        this.servicioCrearPoliza = servicioCrearPoliza;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPoliza comandoPoliza) {
        Poliza poliza = this.fabricaPoliza.crear(comandoPoliza);
        return new ComandoRespuesta<>(this.servicioCrearPoliza.ejecutar(poliza));
    }
}
