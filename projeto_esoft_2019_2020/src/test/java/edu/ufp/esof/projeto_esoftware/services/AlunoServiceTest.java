package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.repositories.AlunoRepoI;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AlunoService.class)
public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoRepoI alunoRepoI;


}
