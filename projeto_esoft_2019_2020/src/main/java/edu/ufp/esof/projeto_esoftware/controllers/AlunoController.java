package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Aluno>> getAllAlunos(){
        Iterable<Aluno> a = alunoService.getAllAlunos();
        return ResponseEntity.ok(a);
    }

    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> createAluno(@RequestBody Aluno aluno){
        Aluno a = alunoService.createAluno(aluno);
        return ResponseEntity.ok(a);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> deleteAluno(@PathVariable("id") Long aid){
        if(alunoService.deleteAluno(aid))return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value="",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> updateAluno(@RequestBody Aluno a){
        alunoService.updateAluno(a);
        return ResponseEntity.ok(a);
    }
}
