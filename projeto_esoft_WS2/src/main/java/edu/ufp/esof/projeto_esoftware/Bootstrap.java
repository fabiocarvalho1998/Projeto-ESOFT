package edu.ufp.esof.projeto_esoftware;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Explicador;
import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Universidade;
import edu.ufp.esof.projeto_esoftware.repositories.ExplicadorRepoI;
import edu.ufp.esof.projeto_esoftware.repositories.UniversidadeRepoI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    @Autowired
    private UniversidadeRepoI urepo;

    @Autowired
    private ExplicadorRepoI erepo;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Universidade u1=new Universidade.UniversidadeBuilder().nome("Universidade Fernando Pessoa").ip("http://localhost:8080/").build();
        Universidade u2=new Universidade.UniversidadeBuilder().nome("FEUP").ip("http://localhost:8081/").build();
        Universidade u3=new Universidade.UniversidadeBuilder().nome("ISEP").ip("http://localhost:8082/").build();
        urepo.save(u1);
        urepo.save(u2);
        urepo.save(u3);
    }
}

