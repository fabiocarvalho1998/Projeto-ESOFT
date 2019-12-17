package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.CadeiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cadeira> updateCadeira(@RequestBody Cadeira c){
        cadeiraService.updateCadeira(c);
        return ResponseEntity.ok(c);
    }

}
