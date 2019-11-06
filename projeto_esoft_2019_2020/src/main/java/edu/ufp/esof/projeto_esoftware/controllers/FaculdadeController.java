package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Faculdade;
import edu.ufp.esof.projeto_esoftware.services.AlunoService;
import edu.ufp.esof.projeto_esoftware.services.FaculdadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculdade")
public class FaculdadeController {
    @Autowired
    private FaculdadeService faculdadeService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Faculdade>> getAllFaculdade(){
        Iterable<Faculdade> c = faculdadeService.getAllFaculdades();
        return ResponseEntity.ok(c);
    }
}
