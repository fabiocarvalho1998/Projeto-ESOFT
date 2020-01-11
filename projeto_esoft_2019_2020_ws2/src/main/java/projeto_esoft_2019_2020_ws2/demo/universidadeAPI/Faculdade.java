package projeto_esoft_2019_2020_ws2.demo.universidadeAPI;

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
}
