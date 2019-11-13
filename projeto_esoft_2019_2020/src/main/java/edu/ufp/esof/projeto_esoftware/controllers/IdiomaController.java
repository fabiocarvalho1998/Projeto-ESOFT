package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.services.AlunoService;
import edu.ufp.esof.projeto_esoftware.services.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idioma")
public class IdiomaController {
    @Autowired
    private IdiomaService idiomaService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Idioma>> getAllIdiomas(){
        Iterable<Idioma> i = idiomaService.getAllIdiomas();
        return ResponseEntity.ok(i);
    }
}
