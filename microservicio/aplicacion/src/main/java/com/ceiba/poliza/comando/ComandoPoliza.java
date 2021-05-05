package com.ceiba.poliza.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("java:S1068")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPoliza {

    private Long id;
    private String nombrePropietario;
    private String telefonoPropietario;
    private String nombreMascota;
    private String tipoMascota;
    private String fechaNacimientoMascota;
    private Double pesoMascota;
    private String alturaMascota;
}
