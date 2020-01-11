package projeto_esoft_2019_2020_ws2.demo.universidadeAPI;

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

    @Column(unique = true)
    private String nome;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "aluno")
    private Set<Explicacao> explicacoes = new HashSet<>();


    public void addExplicacao(Explicacao e) {
        this.explicacoes.add(e);
        e.setAluno(this);
    }

    public void removeExplicacao(Explicacao exp) {
        this.explicacoes.remove(exp);
    }


}
