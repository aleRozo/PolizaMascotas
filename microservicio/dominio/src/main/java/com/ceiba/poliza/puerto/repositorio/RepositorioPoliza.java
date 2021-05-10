package com.ceiba.poliza.puerto.repositorio;

import com.ceiba.poliza.modelo.entidad.Poliza;

public interface RepositorioPoliza {
    /**
     * Permite crear una poliza
     * @param poliza
     * @return el id generado
     */
    Long crear(Poliza poliza);

    /**
     * Permite eliminar una poliza
     * @param id
     * @return
     */
    Long eliminar(Long id);

    /**
     * Permite validar si existe una poliza a nombre de un propietario y una mascota
     * @param nombrePropietario
     * @param nombreMascota
     * @return si existe o no
     */
    boolean existe(String nombrePropietario, String nombreMascota);

    /**
     * Permite validar si existe una poliza con un id
     * @param id
     * @return si existe o no
     */
    boolean existeId(long id);

}
