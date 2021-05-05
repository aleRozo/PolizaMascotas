package com.ceiba.poliza.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.poliza.modelo.entidad.Poliza;
import com.ceiba.poliza.puerto.repositorio.RepositorioPoliza;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class ServicioCrearPoliza {

    private static final String SE_DEBE_INGRESAR_UNA_FECHA_DE_NACIMIENTO_VALIDA_EN_EL_CALENDARIO = "Se debe ingresar una fecha de nacimiento valida en el calendario";
    private static final String LA_POLIZA_YA_EXISTE_EN_EL_SISTEMA = "La poliza ya existe en el sistema";

    private final RepositorioPoliza repositorioPoliza;

    public ServicioCrearPoliza(RepositorioPoliza repositorioPoliza) {
        this.repositorioPoliza = repositorioPoliza;
    }

    public Long ejecutar(Poliza poliza) {
        validarExistenciaPrevia(poliza);
        calcularValor(poliza);
        aplicarDescuentosCumpleanos(poliza);
        establecerFechaTerminacion(poliza);
        return this.repositorioPoliza.crear(poliza);
    }

    private void validarExistenciaPrevia(Poliza poliza) {
        boolean existe = this.repositorioPoliza.existe(poliza.getNombrePropietario(), poliza.getNombreMascota());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_POLIZA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void calcularValor(Poliza poliza) {
        double pesoMascota = poliza.getPesoMascota();
        BigDecimal valor = Poliza.VALOR_UNITARIO;
        if (pesoMascota >= 1.0) {
            valor = valor.multiply(BigDecimal.valueOf(pesoMascota));
        }
        poliza.setValorPoliza(valor);
    }

    private void aplicarDescuentosCumpleanos(Poliza poliza) {
        validarFechaEnElCalendario(poliza);
        BigDecimal valorPoliza = poliza.getValorPoliza();
        BigDecimal valorDescuento;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Poliza.FORMATO_FECHA);
        LocalDate fechaNacimientoMascota = LocalDate.parse(poliza.getFechaNacimientoMascota(), dateTimeFormatter);
        int diaDelMes = fechaNacimientoMascota.getDayOfMonth();
        if (diaDelMes % 2 == 0) {
            valorDescuento = valorPoliza.multiply(BigDecimal.valueOf(0.05));
        } else {
            valorDescuento = valorPoliza.multiply(BigDecimal.valueOf(0.07));
        }
        valorPoliza = valorPoliza.subtract(valorDescuento);
        poliza.setValorPoliza(valorPoliza);
    }

    private void validarFechaEnElCalendario(Poliza poliza) {
        String[] fechaNacimientoArray = poliza.getFechaNacimientoMascota().split("-");
        String fechaFormatoIso = fechaNacimientoArray[2] + "-" + fechaNacimientoArray[1] + "-" + fechaNacimientoArray[0];
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        try {
            LocalDate.parse(fechaFormatoIso, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            throw new ExcepcionValorInvalido(SE_DEBE_INGRESAR_UNA_FECHA_DE_NACIMIENTO_VALIDA_EN_EL_CALENDARIO);
        }
    }

    private void establecerFechaTerminacion(Poliza poliza) {
        LocalDateTime fechaTerminacion = poliza.getFechaInicio().plusYears(1);
        String diaDeLaSemana = fechaTerminacion.getDayOfWeek().name();
        if (diaDeLaSemana.equals(DayOfWeek.SATURDAY.name())) {
            fechaTerminacion = fechaTerminacion.plusDays(2);
        } else if (diaDeLaSemana.equals(DayOfWeek.SUNDAY.name())) {
            fechaTerminacion = fechaTerminacion.plusDays(1);
        }
        poliza.setFechaTerminacion(fechaTerminacion);
    }


}
