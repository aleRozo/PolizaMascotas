package com.ceiba.poliza.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.poliza.servicio.ServicioEliminarPoliza;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarPoliza implements ManejadorComando<Long> {

    private final ServicioEliminarPoliza servicioEliminarPoliza;

    public ManejadorEliminarPoliza(ServicioEliminarPoliza servicioEliminarPoliza) {
        this.servicioEliminarPoliza = servicioEliminarPoliza;
    }

    public void ejecutar(Long idPoliza) {
        this.servicioEliminarPoliza.ejecutar(idPoliza);
    }
}
