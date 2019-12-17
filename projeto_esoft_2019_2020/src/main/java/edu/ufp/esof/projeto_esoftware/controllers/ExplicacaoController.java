package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.models.Explicacao;
import edu.ufp.esof.projeto_esoftware.services.ExplicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/explicacao")
public class ExplicacaoController {
    @Autowired
    private ExplicacaoService explicacaoService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Explicacao>> getAllExplicacoes(){
        Iterable<Explicacao> e = explicacaoService.getAllExplicacoes();
        return ResponseEntity.ok(e);
    }

    @RequestMapping(value="",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicacao> createExplicacao(@RequestBody Explicacao explicacao){
        Explicacao e = explicacaoService.createExplicacao(explicacao);
        return ResponseEntity.ok(e);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicacao> deleteExplicacao(@PathVariable("id") Long eid){
        if(explicacaoService.deleteExplicacao(eid))return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value="",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicacao> updateExplicacao(@RequestBody Explicacao e){
        explicacaoService.updateExplicacao(e);
        return ResponseEntity.ok(e);
    }
}