package edu.ufp.esof.projeto_esoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
//@Entity
public class Cadeira {/*
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Curso curso;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Explicacao> explicacoes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Explicador> explicadores = new HashSet<>();

    public void addExplicador(Explicador explicador){
        this.getExplicadores().add(explicador);
        explicador.getCadeiras().add(this);
    }

    public void addExplicacao(Explicacao explicacao){
        this.getExplicacoes().add(explicacao);
        explicacao.setCadeira(this);
    }*/
}
