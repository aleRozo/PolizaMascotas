package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoPoliza;

public class ComandoPolizaTestDataBuilder {

    private Long id;
    private String nombrePropietario;
    private String telefonoPropietario;
    private String nombreMascota;
    private String tipoMascota;
    private String fechaNacimientoMascota;
    private Double pesoMascota;
    private String alturaMascota;

    public ComandoPolizaTestDataBuilder() {
        nombrePropietario = "Nombre Propietario";
        telefonoPropietario = "1234";
        nombreMascota = "Nombre Mascota";
        tipoMascota = "Tipo Mascota";
        fechaNacimientoMascota = "12-12-2020";
        pesoMascota = 2.0;
        alturaMascota = "20";
    }

    public ComandoPoliza build() {
        return new ComandoPoliza(
                id,
                nombrePropietario,
                telefonoPropietario,
                nombreMascota,
                tipoMascota,
                fechaNacimientoMascota,
                pesoMascota,
                alturaMascota);
    }
}
