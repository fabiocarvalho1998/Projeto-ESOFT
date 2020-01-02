package edu.ufp.esof.projeto_esoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Curso {
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Cadeira> cadeiras = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Faculdade faculdade;

    public void addCadeira(Cadeira cadeira){
        this.getCadeiras().add(cadeira);
        cadeira.setCurso(this);
    }
}
