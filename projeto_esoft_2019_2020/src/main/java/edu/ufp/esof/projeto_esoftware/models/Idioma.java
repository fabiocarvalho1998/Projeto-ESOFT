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
public class Idioma {
<<<<<<< Updated upstream
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idioma;

=======
>>>>>>> Stashed changes
    @ManyToMany(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Explicador> explicadores = new HashSet<>();

    public void addExplicador(Explicador explicador) {
        this.explicadores.add(explicador);
        explicador.getIdiomas().add(this);
    }
}
