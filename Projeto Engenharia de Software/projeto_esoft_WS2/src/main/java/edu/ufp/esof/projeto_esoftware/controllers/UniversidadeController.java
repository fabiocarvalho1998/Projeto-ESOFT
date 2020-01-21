package edu.ufp.esof.projeto_esoftware.controllers;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Explicador;
import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Faculdade;
import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Universidade;
import edu.ufp.esof.projeto_esoftware.services.UniversidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


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
        this.logger.info("Pedido GET Enviado!");
        Iterable<Universidade> u = universidadeService.getAllUniversidades();
        return ResponseEntity.ok(u);
    }

    @GetMapping(value = "/faculdade")
    public Iterable<Universidade> getAllFaculdadesDaUniversidade(){
        for(Universidade u: universidadeService.getAllUniversidades()){
            String path=u.getIp().concat("faculdade");
            HttpHeaders headers= new HttpHeaders();
            HttpEntity<String> nullBody=new HttpEntity<>(null,headers);
            ResponseEntity<Faculdade[]> responseEntity=makeRequest(path,HttpMethod.GET,nullBody,Faculdade[].class);
            this.logger.info("Pedido GET Enviado!");

            for(Faculdade f: responseEntity.getBody()){
                u.addFaculdade(f);
            }
            universidadeService.saveRepoUniversidade(u);
        }
        return universidadeService.getAllUniversidades();
    }

    private ResponseEntity makeRequest(String path, HttpMethod method, HttpEntity request, Class responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, method, request, responseType);
    }
}
