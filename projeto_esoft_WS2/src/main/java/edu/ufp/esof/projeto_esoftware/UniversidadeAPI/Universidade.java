package edu.ufp.esof.projeto_esoftware.UniversidadeAPI;

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
    @OneToMany
    private Set<Faculdade> explicadores = new HashSet<>();
    private LocalDateTime updatedon;


    public void addExplicador(Explicador e){
        this.addExplicador(e);
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



    public static UniversidadeBuilder builder() {
        return new UniversidadeBuilder();
    }
    public static class UniversidadeBuilder {
        private long id;
        private String nome;
        private String ip;

        public UniversidadeBuilder nome(String n) {
            this.nome=n;
            return this;
        }

        public UniversidadeBuilder ip(String ip) {
            this.ip=ip;
            return this;
        }

        public Universidade build() {
            Universidade u = new Universidade();
            u.setNome(nome);
            u.setIp(ip);
            return u;
        }
    }
}
