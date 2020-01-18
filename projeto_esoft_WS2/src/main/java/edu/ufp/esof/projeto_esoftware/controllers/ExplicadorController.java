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

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;
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
        this.logger.info("Pedido GET Enviado!");
        Iterable<Explicador> e = explicadorService.getAllExplicadores();
        return ResponseEntity.ok(e);
    }


    @RequestMapping(value="/{id_universidade}/{id_cadeira}",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> updateExplicadorComCadeira(@RequestBody Explicador ex ,@PathVariable("id_universidade")Long idUniversidade ,@PathVariable("id_cadeira")Long idCadeira){
        Optional<Universidade> optionalUniversidade=universidadeService.getUniversidadeById(idUniversidade);
        if(optionalUniversidade.isPresent()) {
            Universidade universidade=optionalUniversidade.get();
            String path = universidade.getIp().concat("explicador/"+idCadeira);
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Explicador> body = new HttpEntity<>(ex, headers);
            ResponseEntity<Explicador> responseEntity = makeRequest(path, HttpMethod.PUT, body, Explicador.class);
            this.logger.info("Pedido PUT Enviado!");
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



    @RequestMapping(value="/{id_universidade}",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> updateExplicador(@RequestBody Explicador ex ,@PathVariable("id_universidade")Long idUniversidade){
        Optional<Universidade> optionalUniversidade=universidadeService.getUniversidadeById(idUniversidade);
        if(optionalUniversidade.isPresent()) {
            Universidade universidade=optionalUniversidade.get();
            String path = universidade.getIp().concat("explicador");
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Explicador> body = new HttpEntity<>(ex, headers);
            ResponseEntity<Explicador> responseEntity = makeRequest(path, HttpMethod.PUT, body, Explicador.class);
            this.logger.info("Pedido PUT Enviado!");
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


    @RequestMapping(value="",method = RequestMethod.GET)
    public ResponseEntity<Explicador> getExplicadores(@RequestParam Map<String,String> query){
        Long idUniversidade=Long.parseLong(query.get("universidade"));
        Long idCadeira=Long.parseLong(query.get("cadeira"));
        DayOfWeek dia=DayOfWeek.valueOf(query.get("dia"));
        LocalTime inicio=LocalTime.parse(query.get("inicio"));
        LocalTime fim=LocalTime.parse(query.get("fim"));

        Optional<Universidade> optionalUniversidade=universidadeService.getUniversidadeById(idUniversidade);
        if(optionalUniversidade.isPresent()) {
            Universidade uni = optionalUniversidade.get();

            String path = uni.getIp().concat("explicador?cadeira=" + idCadeira + "&dia=" + dia + "&inicio=" + inicio + "&fim=" + fim);

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> nullBody = new HttpEntity<>(null, headers);
            ResponseEntity<Explicador> responseEntity = makeRequest(path, HttpMethod.GET, nullBody, Explicador[].class);
            this.logger.info("Pedido GET Enviado!");

            return ResponseEntity.ok(responseEntity.getBody());
        }
        return ResponseEntity.badRequest().build();
    }


    private ResponseEntity makeRequest(String path, HttpMethod method, HttpEntity request, Class responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, method, request, responseType);
    }
}
