package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Faculdade;
import edu.ufp.esof.projeto_esoftware.services.FaculdadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
        Iterable<Faculdade> f = faculdadeService.getAllFaculdades();
        return ResponseEntity.ok(f);
    }

    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faculdade> createExplicador(@RequestBody Faculdade faculdade){
        Faculdade f = faculdadeService.createFaculdade(faculdade);
        return ResponseEntity.ok(f);
    }
}

