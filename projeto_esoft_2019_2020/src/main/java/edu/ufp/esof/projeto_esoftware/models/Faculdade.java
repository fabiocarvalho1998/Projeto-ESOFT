package edu.ufp.esof.projeto_esoftware.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Faculdade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
/*
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Curso> cursos = new HashSet<>();

    public void addCurso(Curso curso){
        this.getCursos().add(curso);
        curso.setFaculdade(this);
    }*/
}
