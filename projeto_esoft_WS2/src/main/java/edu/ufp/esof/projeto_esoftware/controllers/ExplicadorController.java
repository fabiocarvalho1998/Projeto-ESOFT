package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Explicador;
import edu.ufp.esof.projeto_esoftware.services.ExplicadorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/explicador")
public class ExplicadorController {
    @Autowired
    private final ExplicadorService explicadorService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ExplicadorController(ExplicadorService explicadorService) {
        this.explicadorService = explicadorService;
    }

    @RequestMapping(value="/{id_universidade}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> createExplicador(@RequestBody Explicador ex, @PathVariable("id_universidade")Long idUniversidade){
        this.logger.info("Pedido POST Recebido!");
        Optional<Explicador> e = explicadorService.createExplicador(ex,idUniversidade);
        return ResponseEntity.ok(e.get());
    }

}
