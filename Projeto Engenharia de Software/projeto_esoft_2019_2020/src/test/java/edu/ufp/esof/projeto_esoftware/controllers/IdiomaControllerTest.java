package edu.ufp.esof.projeto_esoftware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.services.IdiomaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = IdiomaController.class)
public class IdiomaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IdiomaService idiomaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createIdioma() throws Exception {

        Idioma idioma = new Idioma.IdiomaBuilder().idioma("Frances").build();
        given(idiomaService.createIdioma(idioma)).willReturn(idioma);


        mockMvc.perform(post("/idioma")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(idioma)))
                .andExpect(status().isOk());
    }
}
