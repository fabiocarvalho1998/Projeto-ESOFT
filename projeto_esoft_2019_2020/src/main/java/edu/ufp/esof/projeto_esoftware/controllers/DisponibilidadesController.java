package edu.ufp.esof.projeto_esoftware.controllers;


import edu.ufp.esof.projeto_esoftware.models.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.services.DisponibilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disponibilidade")
public class DisponibilidadesController {
    @Autowired
    private DisponibilidadeService disponibilidadeService;

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Disponibilidade>> getAllDisponibilidades(){
        Iterable<Disponibilidade> d = disponibilidadeService.getAllDisponibilidades();
        return ResponseEntity.ok(d);
    }
}
