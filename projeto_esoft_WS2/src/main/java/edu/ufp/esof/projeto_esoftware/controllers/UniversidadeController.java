package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Universidade;
import edu.ufp.esof.projeto_esoftware.services.UniversidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/universidade")
public class UniversidadeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UniversidadeService universidadeService;

    public UniversidadeController(UniversidadeService uService) {
        this.universidadeService = uService;
    }

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Universidade>> getAllUniversidades(){
        this.logger.info("Pedido GET Recebido!");
        Iterable<Universidade> u = universidadeService.getAllUniversidades();
        return ResponseEntity.ok(u);
    }
}
