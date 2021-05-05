package com.ceiba.configuracion;

import com.ceiba.poliza.puerto.repositorio.RepositorioPoliza;
import com.ceiba.poliza.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearPoliza servicioCrearPoliza(RepositorioPoliza repositorioPoliza) {
        return new ServicioCrearPoliza(repositorioPoliza);
    }

    @Bean
    public ServicioEliminarPoliza servicioEliminarPoliza(RepositorioPoliza repositorioPoliza) {
        return new ServicioEliminarPoliza(repositorioPoliza);
    }
}
