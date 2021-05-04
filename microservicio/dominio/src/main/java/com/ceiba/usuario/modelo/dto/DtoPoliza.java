package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoPoliza {
    private Long id;
    private String nombrePropietario;
    private String telefonoPropietario;
    private String nombreMascota;
    private String tipoMascota;
    private LocalDate fechaNacimientoMascota;
    private String pesoMascota;
    private String alturaMascota;
    private BigDecimal valorPoliza;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaTerminacion;

}