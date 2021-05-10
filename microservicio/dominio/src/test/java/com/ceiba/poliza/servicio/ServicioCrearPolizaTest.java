package com.ceiba.poliza.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.poliza.modelo.entidad.Poliza;
import com.ceiba.poliza.puerto.repositorio.RepositorioPoliza;
import com.ceiba.poliza.testdatabuilder.PolizaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class ServicioCrearPolizaTest {


    @Test
    public void validarPolizaExistenciaPreviaTest() {
        Poliza poliza = new PolizaTestDataBuilder().build();
        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(true);
        ServicioCrearPoliza servicioCrearPoliza = new ServicioCrearPoliza(repositorioPoliza);

        BasePrueba.assertThrows(() -> servicioCrearPoliza.ejecutar(poliza), ExcepcionDuplicidad.class,"La poliza ya existe en el sistema");
        Mockito.verify(repositorioPoliza, Mockito.times(0)).crear(Mockito.any());

    }

    @Test
    public void validarCrearPolizaDiaImparTest() {
        Poliza poliza = new PolizaTestDataBuilder().build();
        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(false);
        ServicioCrearPoliza servicioCrearPoliza = new ServicioCrearPoliza(repositorioPoliza);

        Assert.assertNotNull(servicioCrearPoliza.ejecutar(poliza));
        Mockito.verify(repositorioPoliza, Mockito.times(1)).crear(Mockito.any());

    }

    @Test
    public void validarCrearPolizaDiaParTest() {
        Poliza poliza = new PolizaTestDataBuilder()
                .conFechaNacimientoMascota("24-12-2020").build();
        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(false);
        ServicioCrearPoliza servicioCrearPoliza = new ServicioCrearPoliza(repositorioPoliza);

        Assert.assertNotNull(servicioCrearPoliza.ejecutar(poliza));
        Mockito.verify(repositorioPoliza, Mockito.times(1)).crear(Mockito.any());

    }

    @Test
    public void validarCrearPolizaFechaInvalidaEnElCalendarioTest() {
        Poliza poliza = new PolizaTestDataBuilder()
                .conFechaNacimientoMascota("30-02-2020").build();
        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(false);
        ServicioCrearPoliza servicioCrearPoliza = new ServicioCrearPoliza(repositorioPoliza);

        BasePrueba.assertThrows(() -> servicioCrearPoliza.ejecutar(poliza), ExcepcionValorInvalido.class,"Se debe ingresar una fecha de nacimiento valida en el calendario");
        Mockito.verify(repositorioPoliza, Mockito.times(0)).crear(Mockito.any());

    }

    @Test
    public void validarCrearPolizaFechaTerminacionSabadoTest() {
        Poliza poliza = Mockito.mock(Poliza.class);
        Mockito.when(poliza.getValorPoliza()).thenReturn(BigDecimal.valueOf(20000.0));
        Mockito.when(poliza.getFechaNacimientoMascota()).thenReturn("10-12-2020");
        Mockito.when(poliza.getFechaInicio()).thenReturn(LocalDateTime.of(2021,5,7,10,10,10));

        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(false);
        ServicioCrearPoliza servicioCrearPoliza = new ServicioCrearPoliza(repositorioPoliza);

        Assert.assertNotNull(servicioCrearPoliza.ejecutar(poliza));
        Mockito.verify(poliza, Mockito.times(1)).setFechaTerminacion(Mockito.any());
        Mockito.verify(repositorioPoliza, Mockito.times(1)).crear(Mockito.any());

    }

    @Test
    public void validarCrearPolizaFechaTerminacionDomingoTest() {
        Poliza poliza = Mockito.mock(Poliza.class);
        Mockito.when(poliza.getValorPoliza()).thenReturn(BigDecimal.valueOf(20000.0));
        Mockito.when(poliza.getFechaNacimientoMascota()).thenReturn("10-12-2020");
        Mockito.when(poliza.getFechaInicio()).thenReturn(LocalDateTime.of(2021,5,8,10,10,10));

        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(false);
        ServicioCrearPoliza servicioCrearPoliza = new ServicioCrearPoliza(repositorioPoliza);

        Assert.assertNotNull(servicioCrearPoliza.ejecutar(poliza));
        Mockito.verify(poliza, Mockito.times(1)).setFechaTerminacion(Mockito.any());
        Mockito.verify(repositorioPoliza, Mockito.times(1)).crear(Mockito.any());

    }
}
