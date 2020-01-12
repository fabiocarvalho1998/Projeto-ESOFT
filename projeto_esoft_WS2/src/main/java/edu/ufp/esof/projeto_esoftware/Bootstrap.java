package edu.ufp.esof.projeto_esoftware;

import edu.ufp.esof.projeto_esoftware.UniversidadeAPI.Universidade;
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

    private UniversidadeRepoI urepo;

    public Bootstrap(UniversidadeRepoI universidadeRepoI) {
        this.urepo = universidadeRepoI;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Universidade u1=new Universidade.UniversidadeBuilder().nome("Universidade Fernando Pessoa").ip("http://localhost:8080/").build();
        urepo.save(u1);
    }
}

