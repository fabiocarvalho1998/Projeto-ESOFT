package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Disponibilidade;
import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Explicacao;
import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Universidade;
import edu.ufp.esof.projeto_esoftware.services.UniversidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/disponibilidade")
public class DisponibilidadeController {
    @Autowired
    private UniversidadeService universidadeService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value="/{id_universidade}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disponibilidade> createDisponibilidade(@RequestBody Disponibilidade d, @PathVariable("id_universidade")Long idUniversidade){

        Optional<Universidade> optionalUniversidade=universidadeService.getUniversidadeById(idUniversidade);
        if(optionalUniversidade.isPresent()) {
            Universidade universidade=optionalUniversidade.get();
            String path = universidade.getIp().concat("disponibilidade");
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Disponibilidade> body = new HttpEntity<>(d, headers);
            ResponseEntity<Disponibilidade> responseEntity = makeRequest(path, HttpMethod.POST, body, Disponibilidade.class);
            this.logger.info("Pedido POST Enviado!");
            if (responseEntity.getStatusCodeValue() == 200) {
                Disponibilidade disponibilidadeFromWS1 = responseEntity.getBody();
                if(disponibilidadeFromWS1!=null) {
                    disponibilidadeFromWS1.setUniversidade(universidade);
                    return ResponseEntity.ok(disponibilidadeFromWS1);
                }
            }
        }

        return ResponseEntity.badRequest().build();

    }




    private ResponseEntity makeRequest(String path, HttpMethod method, HttpEntity request, Class responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, method, request, responseType);
    }
}
