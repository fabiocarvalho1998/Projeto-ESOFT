package edu.ufp.esof.projeto_esoftware.controllers;


import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.models.Idioma;
import edu.ufp.esof.projeto_esoftware.services.DisponibilidadeService;
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
@RequestMapping("/disponibilidade")
public class DisponibilidadesController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DisponibilidadeService disponibilidadeService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Disponibilidade>> getAllDisponibilidades(){
        this.logger.info("Pedido GET Recebido!");
        Iterable<Disponibilidade> d = disponibilidadeService.getAllDisponibilidades();
        return ResponseEntity.ok(d);
    }

    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disponibilidade> createDisponibilidade(@RequestBody Disponibilidade d){
        this.logger.info("Pedido POST Recebido!");
        Disponibilidade dis = disponibilidadeService.createDisponibilidade(d);
        return ResponseEntity.ok(dis);
    }

    @RequestMapping(value="",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disponibilidade> updateDisponibilidade(@RequestBody Disponibilidade d){
        this.logger.info("Pedido PUT Recebido!");
        disponibilidadeService.updateDisponibilidade(d);
        return ResponseEntity.ok(d);
    }
}
