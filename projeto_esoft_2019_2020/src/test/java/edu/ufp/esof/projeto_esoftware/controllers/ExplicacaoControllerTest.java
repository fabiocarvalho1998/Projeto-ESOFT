package edu.ufp.esof.projeto_esoftware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.services.ExplicacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ExplicacaoController.class)
public class ExplicacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExplicacaoService explicacaoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createExplicacao() throws Exception {
        Explicacao explicacao = new Explicacao.ExplicacaoBuilder().dataInicio(LocalDateTime.of(2020, 1, 1, 15, 0)).
                dataFim(LocalDateTime.of(2020, 1, 1, 16, 0)).build();
        given(explicacaoService.createExplicacao(explicacao)).willReturn(explicacao);

        mockMvc.perform(post("/explicacao")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(explicacao)))
                .andExpect(status().isOk());
    }
}
