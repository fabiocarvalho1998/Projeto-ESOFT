package edu.ufp.esof.projeto_esoftware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Curso;
import edu.ufp.esof.projeto_esoftware.services.CadeiraService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CadeiraController.class)
public class CadeiraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CadeiraService cadeiraService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllCadeiras() {
        try {
            this.mockMvc.perform(get("/cadeira")).andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void createCadeira() throws Exception {
        Cadeira cadeira = new Cadeira.CadeiraBuilder().nome("Engenharia de Software").build();
        Curso curso = new Curso.CursoBuilder().nome("Engenharia Informática").build();
        curso.setId(1L);

        given(cadeiraService.createCadeira(cadeira,curso.getId())).willReturn(Optional.of(cadeira));

        mockMvc.perform(post("/cadeira/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(cadeira)))
                .andExpect(status().isOk());

    }

}
