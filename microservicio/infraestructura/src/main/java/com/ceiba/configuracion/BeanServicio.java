package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioPoliza;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearPoliza servicioCrearPoliza(RepositorioPoliza repositorioPoliza) {
        return new ServicioCrearPoliza(repositorioPoliza);
    }

    @Bean
    public ServicioEliminarPoliza servicioEliminarPoliza(RepositorioPoliza repositorioPoliza) {
        return new ServicioEliminarPoliza(repositorioPoliza);
    }
}
