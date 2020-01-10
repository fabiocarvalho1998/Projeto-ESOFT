package edu.ufp.esof.projeto_esoftware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.services.AlunoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AlunoController.class)
public class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoService alunoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createAluno() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setNome("aluno1");

        String jsonRequest = this.objectMapper.writeValueAsString(aluno);

        doReturn(Optional.of(aluno)).when(alunoService.createAluno(aluno));

        this.mockMvc.perform(
                post("/aluno").contentType(MediaType.APPLICATION_JSON).content(jsonRequest)
        ).andExpect(
                status().isOk()
        );

        Aluno existingAluno = new Aluno();
        aluno.setNome("aluno2");

        doReturn(Optional.empty()).when(this.alunoService.createAluno(existingAluno));

        String existingAlunoJson = this.objectMapper.writeValueAsString(existingAluno);

        this.mockMvc.perform(
                post("/aluno").contentType(MediaType.APPLICATION_JSON).content(existingAlunoJson)
        ).andExpect(
                status().isBadRequest()
        );
    }

    @Test
    void getAllAlunos(){
    }


}
