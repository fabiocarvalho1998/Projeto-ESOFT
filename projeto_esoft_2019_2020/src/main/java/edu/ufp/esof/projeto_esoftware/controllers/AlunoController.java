package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.AlunoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Aluno>> getAllAlunos(){
        this.logger.info("Pedido GET Recebido!");
        Iterable<Aluno> a = alunoService.getAllAlunos();
        return ResponseEntity.ok(a);
    }

    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createAluno(@RequestBody Aluno aluno){
        try {
            this.logger.info("Pedido POST Recebido!");
            Aluno a = alunoService.createAluno(aluno);
            return ResponseEntity.ok(a);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erro: "+e.getMessage());
        }
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> deleteAluno(@PathVariable("id") Long aid){
        this.logger.info("Pedido DELETE Recebido!");
        if(alunoService.deleteAluno(aid))return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value="",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> updateAluno(@RequestBody Aluno a){
        this.logger.info("Pedido PUT Recebido!");
        alunoService.updateAluno(a);
        return ResponseEntity.ok(a);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Aluno não existe!")
    private static class NoAlunoExcpetion extends RuntimeException {

        public NoAlunoExcpetion(Long id) {
            super("Não existe o aluno com o id: "+id);
        }
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Aluno já existe!")
    private static class AlunoAlreadyExistsExcpetion extends RuntimeException {

        public AlunoAlreadyExistsExcpetion(String name) {
            super("O aluno: "+name+" já existe!");
        }
    }

}
