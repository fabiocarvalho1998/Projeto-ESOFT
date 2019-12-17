package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Curso;
import edu.ufp.esof.projeto_esoftware.services.AlunoService;
import edu.ufp.esof.projeto_esoftware.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Curso>> getAllCursos(){
        Iterable<Curso> c = cursoService.getAllCursos();
        return ResponseEntity.ok(c);
    }

    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso){
        Curso c = cursoService.createCurso(curso);
        return ResponseEntity.ok(c);
    }

    @RequestMapping(value="",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso c){
        cursoService.updateCurso(c);
        return ResponseEntity.ok(c);
    }
}
