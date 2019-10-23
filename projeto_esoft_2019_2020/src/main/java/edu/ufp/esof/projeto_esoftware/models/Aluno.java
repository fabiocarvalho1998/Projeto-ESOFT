package edu.ufp.esof.projeto_esoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    //@EqualsAndHashCode.Exclude
    //@JsonIgnore
    //@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "Aluno")
    //private Set<Explicacao> explicacoes=new HashSet<>();

}
