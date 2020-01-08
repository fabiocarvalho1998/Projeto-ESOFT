package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.services.CadeiraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cadeira")
public class CadeiraController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final CadeiraService cadeiraService;

    @Autowired
    public CadeiraController(CadeiraService cadeiraService) {
        this.cadeiraService = cadeiraService;
    }

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Cadeira>> getAllCadeiras(){
        this.logger.info("Pedido GET Recebido!");
        Iterable<Cadeira> c = cadeiraService.getAllCadeiras();
        return ResponseEntity.ok(c);
    }

    @RequestMapping(value="/{id_curso}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cadeira> createCadeira(@RequestBody Cadeira cadeira,@PathVariable("id_curso")Long idCurso){
        this.logger.info("Pedido POST Recebido!");
        Optional<Cadeira> c = cadeiraService.createCadeira(cadeira,idCurso);
        return ResponseEntity.ok(c.get());
    }

    @RequestMapping(value="",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cadeira> updateCadeira(@RequestBody Cadeira c){
        this.logger.info("Pedido PUT Recebido!");
        cadeiraService.updateCadeira(c);
        return ResponseEntity.ok(c);
    }

}
