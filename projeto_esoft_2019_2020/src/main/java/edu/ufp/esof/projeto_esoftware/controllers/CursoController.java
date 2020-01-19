package edu.ufp.esof.projeto_esoftware.controllers;


import edu.ufp.esof.projeto_esoftware.models.Curso;
import edu.ufp.esof.projeto_esoftware.services.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CursoService cursoService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Curso>> getAllCursos(){
        this.logger.info("Pedido GET Recebido!");
        Iterable<Curso> c = cursoService.getAllCursos();
        return ResponseEntity.ok(c);
    }



    @RequestMapping(value="",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso c){
        this.logger.info("Pedido PUT Recebido!");
        cursoService.updateCurso(c);
        return ResponseEntity.ok(c);
    }

    @RequestMapping(value="/{id_faculdade}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso, @PathVariable("id_faculdade")Long idFaculdade){
        this.logger.info("Pedido POST Recebido!");
        Optional<Curso> c = cursoService.createCurso(curso,idFaculdade);
        return ResponseEntity.ok(c.get());
    }
}
