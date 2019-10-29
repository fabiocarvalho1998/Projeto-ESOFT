package edu.ufp.esof.projeto_esoftware.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
//@Entity
public class Faculdade {/*
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Curso> cursos = new HashSet<>();

    public void addCurso(Curso curso){
        this.getCursos().add(curso);
        curso.setFaculdade(this);
    }*/
}
