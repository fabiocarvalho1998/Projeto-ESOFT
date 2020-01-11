package projeto_esoft_2019_2020_ws2.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import projeto_esoft_2019_2020_ws2.demo.repositories.UniversidadesRepoI;
import projeto_esoft_2019_2020_ws2.demo.universidadeAPI.Universidade;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    @Autowired
    private UniversidadesRepoI urepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        urepo.save(new Universidade("Universidade 1", "http://localhost:8080/"));
    }
}
