package com.ceiba.poliza.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.poliza.puerto.repositorio.RepositorioPoliza;

public class ServicioEliminarPoliza {

    private static final String LA_POLIZA_NO_EXISTE_EN_EL_SISTEMA = "La poliza que intenta eliminar no existe en el sistema";

    private final RepositorioPoliza repositorioPoliza;

    public ServicioEliminarPoliza(RepositorioPoliza repositorioPoliza) {
        this.repositorioPoliza = repositorioPoliza;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioPoliza.eliminar(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioPoliza.existeId(id);
        if(!existe) {
            throw new ExcepcionSinDatos(LA_POLIZA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
