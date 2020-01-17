package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Explicacao;
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
@RequestMapping("/explicacao")
public class ExplicacaoController {


    @Autowired
    private UniversidadeService universidadeService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value="/{id_universidade}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicacao> createExplicacao(@RequestBody Explicacao ex, @PathVariable("id_universidade")Long idUniversidade){

        Optional<Universidade> optionalUniversidade=universidadeService.getUniversidadeById(idUniversidade);
        if(optionalUniversidade.isPresent()) {
            Universidade universidade=optionalUniversidade.get();
            String path = universidade.getIp().concat("explicacao");
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Explicacao> body = new HttpEntity<>(ex, headers);
            ResponseEntity<Explicacao> responseEntity = makeRequest(path, HttpMethod.POST, body, Explicacao.class);
            this.logger.info("Pedido POST Enviado!");
            if (responseEntity.getStatusCodeValue() == 200) {
                Explicacao explicacaoFromWS1 = responseEntity.getBody();
                if(explicacaoFromWS1!=null) {
                    explicacaoFromWS1.setUniversidade(universidade);
                    return ResponseEntity.ok(explicacaoFromWS1);
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
