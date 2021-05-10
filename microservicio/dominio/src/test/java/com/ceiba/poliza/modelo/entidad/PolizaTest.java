package com.ceiba.poliza.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.poliza.testdatabuilder.PolizaTestDataBuilder;
import org.junit.Test;

public class PolizaTest {

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
}
