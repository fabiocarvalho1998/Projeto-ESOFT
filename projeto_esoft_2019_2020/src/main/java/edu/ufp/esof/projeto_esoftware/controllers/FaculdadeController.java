package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Faculdade;
import edu.ufp.esof.projeto_esoftware.services.FaculdadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FaculdadeService faculdadeService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Faculdade>> getAllFaculdade(){
        this.logger.info("Pedido GET Recebido!");
        Iterable<Faculdade> f = faculdadeService.getAllFaculdades();
        return ResponseEntity.ok(f);
    }

    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faculdade> createExplicador(@RequestBody Faculdade faculdade){
        this.logger.info("Pedido POST Recebido!");
        Faculdade f = faculdadeService.createFaculdade(faculdade);
        return ResponseEntity.ok(f);
    }

    @RequestMapping(value="",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faculdade> updateFaculdade(@RequestBody Faculdade f){
        this.logger.info("Pedido PUT Recebido!");
        faculdadeService.updateFaculdade(f);
        return ResponseEntity.ok(f);
    }
}

