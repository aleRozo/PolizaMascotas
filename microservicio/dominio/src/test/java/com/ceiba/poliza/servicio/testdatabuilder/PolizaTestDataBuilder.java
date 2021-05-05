package com.ceiba.poliza.servicio.testdatabuilder;

import com.ceiba.poliza.modelo.entidad.Poliza;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PolizaTestDataBuilder {

    private Long id;
    private String nombrePropietario;
    private String telefonoPropietario;
    private String nombreMascota;
    private String tipoMascota;
    private String fechaNacimientoMascota;
    private Double pesoMascota;
    private String alturaMascota;
    private BigDecimal valorPoliza;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaTerminacion;

    public PolizaTestDataBuilder() {
        nombrePropietario = "Alejandra Rozo";
        telefonoPropietario = "1234567890";
        nombreMascota = "Kenny";
        tipoMascota = "Perro";
        fechaNacimientoMascota = "25-12-2020";
        pesoMascota = 2.0;
        alturaMascota = "80";
    }

    public PolizaTestDataBuilder conNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
        return this;
    }

    public PolizaTestDataBuilder conTelefonoPropietario(String telefonoPropietario) {
        this.telefonoPropietario = telefonoPropietario;
        return this;
    }

    public PolizaTestDataBuilder conNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
        return this;
    }

    public PolizaTestDataBuilder conTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
        return this;
    }

    public PolizaTestDataBuilder conFechaNacimientoMascota(String fechaNacimientoMascota) {
        this.fechaNacimientoMascota = fechaNacimientoMascota;
        return this;
    }

    public PolizaTestDataBuilder conPesoMascota(Double pesoMascota) {
        this.pesoMascota = pesoMascota;
        return this;
    }



    public Poliza build() {
        return new Poliza(
                nombrePropietario,
                telefonoPropietario,
                nombreMascota,
                tipoMascota,
                fechaNacimientoMascota,
                pesoMascota,
                alturaMascota
        );
    }
}
