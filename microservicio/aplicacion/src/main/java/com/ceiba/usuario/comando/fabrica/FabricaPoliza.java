package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoPoliza;
import com.ceiba.usuario.modelo.entidad.Poliza;
import org.springframework.stereotype.Component;

@Component
public class FabricaPoliza {

    public Poliza crear(ComandoPoliza comandoPoliza) {
        return new Poliza(
                comandoPoliza.getId(),
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
