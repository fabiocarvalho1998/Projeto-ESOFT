package edu.ufp.esof.projeto_esoftware.services;

import edu.ufp.esof.projeto_esoftware.models.Cadeira;
import edu.ufp.esof.projeto_esoftware.repositories.CadeiraRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadeiraService {
    @Autowired
    private CadeiraRepoI cadeiraRepo;

    public Iterable<Cadeira> getAllCadeiras(){
        return cadeiraRepo.findAll();
    }
}
