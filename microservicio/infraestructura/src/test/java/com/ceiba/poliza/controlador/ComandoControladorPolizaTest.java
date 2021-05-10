package com.ceiba.poliza.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.poliza.comando.ComandoPoliza;
import com.ceiba.poliza.comando.fabrica.FabricaPoliza;
import com.ceiba.poliza.puerto.repositorio.RepositorioPoliza;
import com.ceiba.poliza.servicio.testdatabuilder.ComandoPolizaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPoliza.class)
public class ComandoControladorPolizaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioPoliza repositorioPoliza;

    @Autowired
    FabricaPoliza fabricaPoliza;

    @Test
    public void crear() throws Exception{

        ComandoPoliza poliza = new ComandoPolizaTestDataBuilder().build();

        mocMvc.perform(post("/polizas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(poliza)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
        Assert.assertTrue(repositorioPoliza.existeId(3L));
    }

    @Test
    public void eliminar() throws Exception {
        Long id = 1L;

        mocMvc.perform(delete("/polizas/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));

        Assert.assertFalse(repositorioPoliza.existe("Nombre Prueba Eliminar","Nombre Perrito"));
    }

    @Test
    public void eliminarPolizaNoExistente() throws Exception {
        Long id = 20L;

        mocMvc.perform(delete("/polizas/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\n" +
                        "    \"nombreExcepcion\": \"ExcepcionSinDatos\",\n" +
                        "    \"mensaje\": \"La poliza que intenta eliminar no existe en el sistema\"\n" +
                        "}"));

        Assert.assertFalse(repositorioPoliza.existeId(id));
    }
}
