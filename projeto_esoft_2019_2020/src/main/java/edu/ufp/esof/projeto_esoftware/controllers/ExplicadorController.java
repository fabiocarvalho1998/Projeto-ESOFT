package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.ExplicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explicador")
public class ExplicadorController {
    @Autowired
    private ExplicadorService explicadorService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Explicador>> getAllExplicadores(){
        Iterable<Explicador> e = explicadorService.getAllExplicadores();
        return ResponseEntity.ok(e);
    }

    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> createExplicador(@RequestBody Explicador explicador){
        Explicador e = explicadorService.createExplicador(explicador);
        return ResponseEntity.ok(e);
    }
}
