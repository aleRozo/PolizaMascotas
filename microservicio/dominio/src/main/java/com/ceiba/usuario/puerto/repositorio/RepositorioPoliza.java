package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Poliza;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioPoliza {
    /**
     * Permite crear una poliza
     * @param poliza
     * @return el id generado
     */
    Long crear(Poliza poliza);
//
//    /**
//     * Permite actualizar un usuario
//     * @param usuario
//     */
//    void actualizar(Usuario usuario);
//
//    /**
//     * Permite eliminar un usuario
//     * @param id
//     */
//    void eliminar(Long id);

    /**
     * Permite validar si existe una poliza a nombre de un propietario y una mascota
     * @param nombrePropietario
     * @param nombreMascota
     * @return si existe o no
     */
    boolean existe(String nombrePropietario, String nombreMascota);
//
//    /**
//     * Permite validar si existe un usuario con un nombre excluyendo un id
//     * @param nombre
//     * @return si existe o no
//     */
//    boolean existeExcluyendoId(Long id,String nombre);

}
