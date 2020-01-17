package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Explicador;
import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Universidade;
import edu.ufp.esof.projeto_esoftware.services.ExplicadorService;
import edu.ufp.esof.projeto_esoftware.services.UniversidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/explicador")
public class ExplicadorController {
    @Autowired
    private final ExplicadorService explicadorService;

    @Autowired
    private UniversidadeService universidadeService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ExplicadorController(ExplicadorService explicadorService) {
        this.explicadorService = explicadorService;
    }

    @RequestMapping(value="/{id_universidade}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> createExplicador(@RequestBody Explicador ex, @PathVariable("id_universidade")Long idUniversidade){

        Optional<Universidade> optionalUniversidade=universidadeService.getUniversidadeById(idUniversidade);
        if(optionalUniversidade.isPresent()) {
            Universidade universidade=optionalUniversidade.get();
            String path = universidade.getIp().concat("explicador");
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Explicador> body = new HttpEntity<>(ex, headers);
            ResponseEntity<Explicador> responseEntity = makeRequest(path, HttpMethod.POST, body, Explicador.class);
            this.logger.info("Pedido POST Enviado!");
            if (responseEntity.getStatusCodeValue() == 200) {
                Explicador explicadorFromWS1 = responseEntity.getBody();
                if(explicadorFromWS1!=null) {
                    explicadorFromWS1.setUniversidade(universidade);
                    return ResponseEntity.ok(explicadorFromWS1);
                }
            }
        }

            return ResponseEntity.badRequest().build();

    }

    @RequestMapping(value="",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Explicador>> getAllExplicadores(){
        this.logger.info("Pedido GET Recebido!");
        Iterable<Explicador> e = explicadorService.getAllExplicadores();
        return ResponseEntity.ok(e);
    }



    private ResponseEntity makeRequest(String path, HttpMethod method, HttpEntity request, Class responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, method, request, responseType);
    }
}
