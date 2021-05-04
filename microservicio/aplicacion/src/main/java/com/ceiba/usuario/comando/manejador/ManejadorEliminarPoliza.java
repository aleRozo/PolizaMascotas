package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarPoliza;
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
