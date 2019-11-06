package edu.ufp.esof.projeto_esoftware.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Explicador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    /*
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Idioma> idiomas = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Disponibilidade> disponibilidades = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Explicacao> explicacoes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Cadeira> cadeiras = new HashSet<>();

    public void addExplicacao(Explicacao explicacao) {
        this.getExplicacoes().add(explicacao);
        explicacao.setExplicador(this);
    }

    public void addCadeira(Cadeira cadeira) {
        this.getCadeiras().add(cadeira);
        cadeira.getExplicadores().add(this);
    }

    public void addDisponibilidade(Disponibilidade disponibilidade) {
        this.getDisponibilidades().add(disponibilidade);
        disponibilidade.setExplicador(this);
    }

    public void addIdioma(Idioma idioma) {
        this.getIdiomas().add(idioma);
        idioma.getExplicadores().add(this);
    }
*/
}
