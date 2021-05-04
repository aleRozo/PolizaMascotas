package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Poliza {

    public static final BigDecimal VALOR_UNITARIO = BigDecimal.valueOf(20000);
    public static final String FORMATO_FECHA = "dd-MM-yyyy";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PROPIETARIO = "Se debe ingresar el nombre del propietario";
    private static final String SE_DEBE_INGRESAR_EL_TELEFONO_DEL_PROPIETARIO = "Se debe ingresar el telefono del propietario";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_MASCOTA = "Se debe ingresar el nombre de la mascota";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_MASCOTA = "Se debe ingresar el tipo de mascota";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO_DE_LA_MASCOTA = "Se debe ingresar la fecha de nacimiento de la mascota";
    private static final String SE_DEBE_INGRESAR_EL_PESO_DE_LA_MASCOTA = "Se debe ingresar el peso de la mascota";
    private static final String SE_DEBE_INGRESAR_SOLO_VALORES_NUMERICOS_EN_EL_TELEFONO_DEL_PROPIETARIO = "Se debe ingresar solo valores numericos en el telefono del propietario";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO_EN_FORMATO_VALIDO = "Se debe ingresar la fecha de nacimiento en formato " + FORMATO_FECHA;



    private Long id;
    private String nombrePropietario;
    private String telefonoPropietario;
    private String nombreMascota;
    private String tipoMascota;
    private String fechaNacimientoMascota;
    private double pesoMascota;
    private String alturaMascota;
    @Setter private BigDecimal valorPoliza;
    private LocalDateTime fechaInicio;
    @Setter private LocalDateTime fechaTerminacion;

    public Poliza(Long id,
            String nombrePropietario,
            String telefonoPropietario,
            String nombreMascota,
            String tipoMascota,
            String fechaNacimientoMascota,
            double pesoMascota,
            String alturaMascota) {

        validarCadenaObligatoria(nombrePropietario, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PROPIETARIO);
        validarCadenaObligatoria(telefonoPropietario, SE_DEBE_INGRESAR_EL_TELEFONO_DEL_PROPIETARIO);
        validarCadenaObligatoria(nombreMascota, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_MASCOTA);
        validarCadenaObligatoria(tipoMascota, SE_DEBE_INGRESAR_EL_TIPO_DE_MASCOTA);
        validarObligatorio(pesoMascota, SE_DEBE_INGRESAR_EL_PESO_DE_LA_MASCOTA);
        validarObligatorio(fechaNacimientoMascota, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO_DE_LA_MASCOTA);
        validarNumerico(telefonoPropietario, SE_DEBE_INGRESAR_SOLO_VALORES_NUMERICOS_EN_EL_TELEFONO_DEL_PROPIETARIO);
        validarFormatoFecha(fechaNacimientoMascota,FORMATO_FECHA, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO_EN_FORMATO_VALIDO);

        this.id = id;
        this.nombrePropietario = nombrePropietario;
        this.telefonoPropietario = telefonoPropietario;
        this.nombreMascota = nombreMascota;
        this.tipoMascota = tipoMascota;
        this.fechaNacimientoMascota = fechaNacimientoMascota;
        this.pesoMascota = pesoMascota;
        this.alturaMascota = alturaMascota;
        this.fechaInicio = LocalDateTime.now();
        this.valorPoliza = BigDecimal.ZERO;
    }


}
