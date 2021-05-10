package com.ceiba.poliza.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.poliza.servicio.ServicioEliminarPoliza;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarPoliza implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Long>> {

    private final ServicioEliminarPoliza servicioEliminarPoliza;

    public ManejadorEliminarPoliza(ServicioEliminarPoliza servicioEliminarPoliza) {
        this.servicioEliminarPoliza = servicioEliminarPoliza;
    }

    public ComandoRespuesta<Long> ejecutar(Long idPoliza) {
        return new ComandoRespuesta<>(this.servicioEliminarPoliza.ejecutar(idPoliza));

    }
}
