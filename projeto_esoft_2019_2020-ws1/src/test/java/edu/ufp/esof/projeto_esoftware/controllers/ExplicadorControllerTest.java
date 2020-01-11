package edu.ufp.esof.projeto_esoftware.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.ExplicadorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ExplicadorController.class)
public class ExplicadorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExplicadorService explicadorService;

    @Autowired
    private ObjectMapper objectMapper;



    @Test
    void getAllExplicadores() {
        try {
            this.mockMvc.perform(get("/explicador")).andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getExplicadorByNome() throws Exception {
        Explicador explicador = new Explicador.ExplicadorBuilder().nome("exp1").build();

        when(this.explicadorService.getExplicadorByNome("exp1")).thenReturn(Optional.of(explicador));
        given(explicadorService.createExplicador(explicador)).willReturn(explicador);

        String responseJson = this.mockMvc.perform(
                get("/explicador/exp1")
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse().getContentAsString();

        Explicador responseExplicador = this.objectMapper.readValue(responseJson, Explicador.class);
        assertEquals(explicador, responseExplicador);

    }

    @Test
    public void createExplicador() throws Exception {

        Explicador e = new Explicador.ExplicadorBuilder().nome("Alessandro Moreira").build();
        given(explicadorService.createExplicador(e)).willReturn(e);


        mockMvc.perform(post("/explicador")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(e)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Alessandro Moreira"));
    }

}
