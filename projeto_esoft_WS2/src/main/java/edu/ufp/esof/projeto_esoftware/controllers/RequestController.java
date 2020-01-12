package edu.ufp.esof.projeto_esoftware.controllers;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RequestController {
    @GetMapping(value = "/teste", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable getAll() {
        //todo qual é o path?
        String path = "http://localhost:8080/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);
        ResponseEntity<Iterable> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, Iterable.class);
        return responseEntity.getBody();
    }

    private ResponseEntity makeRequest(String path, HttpMethod method, HttpEntity request, Class responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, method, request, responseType);
    }
}
