package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.services.CadeiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadeira")
public class CadeiraController {
    @Autowired
    private CadeiraService cadeiraService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Cadeira>> getAllCadeiras(){
        Iterable<Cadeira> c = cadeiraService.getAllCadeiras();
        return ResponseEntity.ok(c);
    }

    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cadeira> createCadeira(@RequestBody Cadeira cadeira){
        Cadeira c = cadeiraService.createCadeira(cadeira);
        return ResponseEntity.ok(c);
    }
}
