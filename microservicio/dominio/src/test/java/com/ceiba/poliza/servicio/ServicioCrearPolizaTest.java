package com.ceiba.poliza.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.poliza.modelo.entidad.Poliza;
import com.ceiba.poliza.puerto.repositorio.RepositorioPoliza;
import com.ceiba.poliza.servicio.testdatabuilder.PolizaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class ServicioCrearPolizaTest {

    @Test
    public void validarNombrePropietarioObligatorioTest() {
        PolizaTestDataBuilder polizaTestDataBuilder = new PolizaTestDataBuilder().conNombrePropietario("");

        BasePrueba.assertThrows(() -> polizaTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del propietario");
    }

    @Test
    public void validarTelefonoPropietarioObligatorioTest() {
        PolizaTestDataBuilder polizaTestDataBuilder = new PolizaTestDataBuilder().conTelefonoPropietario(null);

        BasePrueba.assertThrows(() -> polizaTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el telefono del propietario");
    }

    @Test
    public void validarNombreMascotaObligatorioTest() {
        PolizaTestDataBuilder polizaTestDataBuilder = new PolizaTestDataBuilder().conNombreMascota(" ");

        BasePrueba.assertThrows(() -> polizaTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de la mascota");
    }

    @Test
    public void validarTipoMascotaObligatorioTest() {
        PolizaTestDataBuilder polizaTestDataBuilder = new PolizaTestDataBuilder().conTipoMascota(null);

        BasePrueba.assertThrows(() -> polizaTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de mascota");
    }

    @Test
    public void validarFechaNacimientoMascotaObligatorioTest() {
        PolizaTestDataBuilder polizaTestDataBuilder = new PolizaTestDataBuilder().conFechaNacimientoMascota(null);

        BasePrueba.assertThrows(() -> polizaTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de nacimiento de la mascota");
    }

    @Test
    public void validarPesoMascotaObligatorioTest() {
        PolizaTestDataBuilder polizaTestDataBuilder = new PolizaTestDataBuilder().conPesoMascota(null);

        BasePrueba.assertThrows(() -> polizaTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el peso de la mascota");
    }

    @Test
    public void validarTelefonoPropietarioNumericoTest() {
        PolizaTestDataBuilder polizaTestDataBuilder = new PolizaTestDataBuilder().conTelefonoPropietario("abcd");

        BasePrueba.assertThrows(() -> polizaTestDataBuilder.build(), ExcepcionValorInvalido.class, "Se debe ingresar solo valores numericos en el telefono del propietario");
    }

    @Test
    public void validarFechaNacimientoMascotaFormatoValidoTest() {
        PolizaTestDataBuilder polizaTestDataBuilder = new PolizaTestDataBuilder().conFechaNacimientoMascota("12/12/2021");

        BasePrueba.assertThrows(() -> polizaTestDataBuilder.build(), ExcepcionValorInvalido.class, "Se debe ingresar la fecha de nacimiento en formato dd-mm-yyyy");
    }

    @Test
    public void validarPolizaExistenciaPreviaTest() {
        Poliza poliza = new PolizaTestDataBuilder().build();
        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(true);
        ServicioCrearPoliza servicioCrearPoliza = new ServicioCrearPoliza(repositorioPoliza);

        BasePrueba.assertThrows(() -> servicioCrearPoliza.ejecutar(poliza), ExcepcionDuplicidad.class,"La poliza ya existe en el sistema");
    }

    @Test
    public void validarCrearPolizaDiaImparTest() {
        Poliza poliza = new PolizaTestDataBuilder().build();
        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(false);
        ServicioCrearPoliza servicioCrearPoliza = new ServicioCrearPoliza(repositorioPoliza);

        Assert.assertNotNull(servicioCrearPoliza.ejecutar(poliza));
    }

    @Test
    public void validarCrearPolizaDiaParTest() {
        Poliza poliza = new PolizaTestDataBuilder()
                .conFechaNacimientoMascota("24-12-2020").build();
        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(false);
        ServicioCrearPoliza servicioCrearPoliza = new ServicioCrearPoliza(repositorioPoliza);

        Assert.assertNotNull(servicioCrearPoliza.ejecutar(poliza));
    }

    @Test
    public void validarCrearPolizaFechaInvalidaEnElCalendarioTest() {
        Poliza poliza = new PolizaTestDataBuilder()
                .conFechaNacimientoMascota("30-02-2020").build();
        RepositorioPoliza repositorioPoliza = Mockito.mock(RepositorioPoliza.class);
        Mockito.when(repositorioPoliza.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(false);
        ServicioCrearPoliza servicioCrearPoliza = new ServicioCrearPoliza(repositorioPoliza);

        BasePrueba.assertThrows(() -> servicioCrearPoliza.ejecutar(poliza), ExcepcionValorInvalido.class,"Se debe ingresar una fecha de nacimiento valida en el calendario");
    }

}
