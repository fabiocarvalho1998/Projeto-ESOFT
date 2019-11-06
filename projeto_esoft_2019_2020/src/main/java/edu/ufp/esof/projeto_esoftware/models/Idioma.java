package edu.ufp.esof.projeto_esoftware.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idioma;
    /*
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Explicador> explicadores = new HashSet<>();

    public void addExplicador(Explicador explicador) {
        this.getExplicadores().add(explicador);
        explicador.getIdiomas().add(this);
    }*/
}
