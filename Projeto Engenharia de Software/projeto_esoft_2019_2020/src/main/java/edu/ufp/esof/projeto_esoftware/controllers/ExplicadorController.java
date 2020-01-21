package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Aluno;
import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.models.Explicador;
import edu.ufp.esof.projeto_esoftware.services.ExplicadorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/explicador")
public class ExplicadorController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExplicadorService explicadorService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getExplicadores(@RequestParam Map<String,String> query){
        this.logger.info("Pedido GET Recebido!");
        return ResponseEntity.ok(explicadorService.listaExplicadores(query));
    }

    public ResponseEntity<Iterable<Explicador>> getAllExplicadores(){
        this.logger.info("Pedido GET Recebido!");
        Iterable<Explicador> e = explicadorService.getAllExplicadores();
        return ResponseEntity.ok(e);
    }

    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> createExplicador(@RequestBody Explicador explicador){
        this.logger.info("Pedido POST Recebido!");
        Explicador e = explicadorService.createExplicador(explicador);
        return ResponseEntity.ok(e);
    }

    @RequestMapping(value="",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> updateExplicador(@RequestBody Explicador ex){
        this.logger.info("Pedido PUT Recebido!");
        explicadorService.updateExplicador(ex);
        return ResponseEntity.ok(ex);
    }


    @RequestMapping(value="/{id_cadeira}",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> updateExplicadorComCadeira(@RequestBody Explicador ex, @PathVariable("id_cadeira")Long idCadeira){
        this.logger.info("Pedido PUT Recebido!");
        Optional<Explicador> e = explicadorService.updateExplicadorComCadeira(ex,idCadeira);
        return ResponseEntity.ok(e.get());
    }

    @RequestMapping(value = "/{nome}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> getExplicadorByNome(@PathVariable String nome) {
        this.logger.info("Pedido GET Recebido!");
        Optional<Explicador> e = explicadorService.getExplicadorByNome(nome);
        return ResponseEntity.ok(e.get());
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Explicador não existe!")
    private static class NoExplicadorExcpetion extends RuntimeException {

        public NoExplicadorExcpetion(Long id) {
            super("Não existe o explicador com o id: "+id);
        }
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Explicador já existe!")
    private static class ExplicadorAlreadyExistsExcpetion extends RuntimeException {

        public ExplicadorAlreadyExistsExcpetion(String name) {
            super("O explicador: "+name+" já existe!");
        }
    }
}