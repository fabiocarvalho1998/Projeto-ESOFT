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
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "aluno")
    private Set<Explicacao> explicacoes=new HashSet<>();

    public void addExplicacao(Explicacao explicacao) {
        this.explicacoes.add(explicacao);
        explicacao.setAluno(this);
    }


    /*Todo*/
    /**Verificar se funciona como quero*/
    public boolean sameName(String n){
        if(this.nome.equals(n)){
            return true;
        }else{
            return false;
        }
    }

}
