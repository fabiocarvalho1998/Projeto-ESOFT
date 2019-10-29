package edu.ufp.esof.projeto_esoftware.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Data
//@Entity
public class Idioma {/**
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Explicador> explicadores = new HashSet<>();

    public void addExplicador(Explicador explicador) {
        this.getExplicadores().add(explicador);
        explicador.getIdiomas().add(this);
    }**/
}
