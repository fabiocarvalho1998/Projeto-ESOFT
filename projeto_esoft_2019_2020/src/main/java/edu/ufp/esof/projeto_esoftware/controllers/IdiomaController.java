package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.services.IdiomaService;
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
@RequestMapping("/idioma")
public class IdiomaController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IdiomaService idiomaService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Idioma>> getAllIdiomas(){
        this.logger.info("Pedido GET Recebido!");
        Iterable<Idioma> i = idiomaService.getAllIdiomas();
        return ResponseEntity.ok(i);
    }

    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Idioma> createIdioma(@RequestBody Idioma idioma){
        this.logger.info("Pedido POST Recebido!");
        Idioma i = idiomaService.createIdioma(idioma);
        return ResponseEntity.ok(i);
    }

    @RequestMapping(value="",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Idioma> updateIdiona(@RequestBody Idioma i){
        this.logger.info("Pedido PUT Recebido!");
        idiomaService.updateIdioma(i);
        return ResponseEntity.ok(i);
    }
}
