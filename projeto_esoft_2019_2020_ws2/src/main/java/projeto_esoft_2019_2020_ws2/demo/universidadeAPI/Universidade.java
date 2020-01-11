package projeto_esoft_2019_2020_ws2.demo.universidadeAPI;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Data
public class Universidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String ip;

    @OneToMany
    private Set<Faculdade> faculdades = new HashSet<>();
    private LocalDateTime updatedon;

    public Universidade(String nome, String ip) {
        this.nome = nome;
        this.ip = ip;
    }

    public boolean temFaculdade(String faculdade) {
        for (Faculdade f : faculdades) {
            if (f.getNome().matches(faculdade))
                return true;
        }
        return false;
    }

    public boolean isValid() {
        return updatedon.plusDays(1).isAfter(LocalDateTime.now());
    }
}
