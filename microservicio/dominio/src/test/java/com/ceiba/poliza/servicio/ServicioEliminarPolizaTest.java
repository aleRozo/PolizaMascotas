package com.ceiba.poliza.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.poliza.puerto.repositorio.RepositorioPoliza;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class ServicioEliminarPolizaTest {

    @Test
    public void validarEliminarPolizaNoExistenteTest() {
        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existeId(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarPoliza servicioEliminarPoliza = new ServicioEliminarPoliza(repositorioPoliza);

        BasePrueba.assertThrows(() -> servicioEliminarPoliza.ejecutar(Long.parseLong("1")), ExcepcionSinDatos.class,"La poliza que intenta eliminar no existe en el sistema");
        Mockito.verify(repositorioPoliza, Mockito.times(0)).eliminar(Mockito.anyLong());
        
    }

    @Test
    public void validarEliminarPolizaExistenteTest() {
        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existeId(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarPoliza servicioEliminarPoliza = new ServicioEliminarPoliza(repositorioPoliza);
        Assert.assertNotNull(servicioEliminarPoliza.ejecutar(Mockito.anyLong()));
        Mockito.verify(repositorioPoliza).eliminar(Mockito.anyLong());
    }
}
