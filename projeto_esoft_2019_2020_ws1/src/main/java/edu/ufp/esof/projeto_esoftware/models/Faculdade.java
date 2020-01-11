package edu.ufp.esof.projeto_esoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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

    @OneToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    //@JsonIgnore
    @JsonManagedReference(value = "faculdadeCursos")
    private Set<Curso> cursos = new HashSet<>();

    public void addCurso(Curso curso){
        this.cursos.add(curso);
        curso.setFaculdade(this);
    }

    public static FaculdadeBuilder builder() {
        return new FaculdadeBuilder();
    }
    public static class FaculdadeBuilder {
        private long id;
        private String nome;

        public FaculdadeBuilder nome(String nome) {
            this.nome=nome;
            return this;
        }
        public Faculdade build() {
            Faculdade f = new Faculdade();
            f.setNome(nome);
            return f;
        }
    }
}
