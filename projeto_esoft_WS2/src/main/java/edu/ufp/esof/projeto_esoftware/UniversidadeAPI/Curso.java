package edu.ufp.esof.projeto_esoftware.UniversidadeAPI;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;



    @OneToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    //@JsonIgnore
    @JsonManagedReference(value = "cursoCadeiras")
    private Set<Cadeira> cadeiras = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    //@JsonIgnore
    @JsonBackReference(value = "faculdadeCursos")
    private Faculdade faculdade;


    public void addCadeira(Cadeira cadeira){
        this.cadeiras.add(cadeira);
        cadeira.setCurso(this);
    }


    @JsonInclude
    //@JsonProperty(value = "faculdade")
    public String getFaculdadeNome(){
        return this.faculdade==null?"null":this.faculdade.getNome();
    }



    public static CursoBuilder builder() {
        return new CursoBuilder();
    }

    public static class CursoBuilder {
        private long id;
        private String nome;
        private Faculdade faculdade;

        public CursoBuilder nome(String nome) {
            this.nome=nome;
            return this;
        }
        public CursoBuilder faculdade(Faculdade f) {
            this.faculdade=f;
            return this;
        }
        public Curso build() {
            Curso c = new Curso();
            c.setNome(nome);
            return c;
        }
    }
}
