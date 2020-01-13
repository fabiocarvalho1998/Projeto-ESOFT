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
        Universidade u1=new Universidade.UniversidadeBuilder().nome("Universidade Fernando Pessoa").ip("http://localhost:9000/").build();
        Explicador e1=new Explicador.ExplicadorBuilder().nome("José").build();
        e1.setUniversidade(u1);
        u1.addExplicador(e1);

        urepo.save(u1);
    }
}

