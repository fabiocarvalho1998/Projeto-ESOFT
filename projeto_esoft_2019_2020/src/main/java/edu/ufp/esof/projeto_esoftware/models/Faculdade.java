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
public class Faculdade {
<<<<<<< Updated upstream
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
=======
>>>>>>> Stashed changes
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Curso> cursos = new HashSet<>();

    public void addCurso(Curso curso){
        this.cursos.add(curso);
        curso.setFaculdade(this);
    }
}
