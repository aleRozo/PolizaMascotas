package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Poliza {

//    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
//    private static final String LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La clave debe tener una longitud mayor o igual a %s";
//    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
//    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
//
//    private static final int LONGITUD_MINIMA_CLAVE = 4;

    public static final BigDecimal VALOR_UNITARIO = BigDecimal.valueOf(20000);
    public static final String FORMATO_FECHA = "dd-MM-yyyy";
    public static final String SE_DEBE_INGRESAR_UNA_FECHA_DE_NACIMIENTO_VALIDA_EN_EL_CALENDARIO = "Se debe ingresar una fecha de nacimiento valida en el calendario";
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
//        this.fechaInicio = LocalDateTime.of(2021,5, 8,3,20);
        this.valorPoliza = BigDecimal.ZERO;
    }


}
