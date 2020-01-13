package edu.ufp.esof.projeto_esoftware.UniversidadeAPI;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Universidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String ip;

    @OneToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Faculdade> faculdades = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference(value = "universidadeExplicadores")
    private Set<Explicador> explicadores = new HashSet<>();



    public void addExplicador(Explicador e){
        this.explicadores.add(e);

    }

    public boolean temFaculdade(String faculdade) {
        for (Faculdade f : faculdades) {
            if (f.getNome().matches(faculdade))
                return true;
        }
        return false;
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
