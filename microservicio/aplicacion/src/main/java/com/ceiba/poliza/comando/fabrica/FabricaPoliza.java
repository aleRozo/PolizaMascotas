package com.ceiba.poliza.comando.fabrica;

import com.ceiba.poliza.comando.ComandoPoliza;
import com.ceiba.poliza.modelo.entidad.Poliza;
import org.springframework.stereotype.Component;

@Component
public class FabricaPoliza {

    public Poliza crear(ComandoPoliza comandoPoliza) {
        return new Poliza(
                comandoPoliza.getNombrePropietario(),
                comandoPoliza.getTelefonoPropietario(),
                comandoPoliza.getNombreMascota(),
                comandoPoliza.getTipoMascota(),
                comandoPoliza.getFechaNacimientoMascota(),
                comandoPoliza.getPesoMascota(),
                comandoPoliza.getAlturaMascota()
        );
    }

}
