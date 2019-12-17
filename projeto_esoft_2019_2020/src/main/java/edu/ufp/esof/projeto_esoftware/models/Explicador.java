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
public class Explicador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    @ManyToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Idioma> idiomas = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Disponibilidade> disponibilidades = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Explicacao> explicacoes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Cadeira> cadeiras = new HashSet<>();





    public void addExplicacao(Explicacao explicacao) {
        this.explicacoes.add(explicacao);
        explicacao.setExplicador(this);
    }

    public void removeExplicacao(Explicacao exp){
        this.explicacoes.remove(exp);
    }

    public void addCadeira(Cadeira cadeira) {
        cadeiras.add(cadeira);
        cadeira.getExplicadores().add(this);
    }

    public void removeCadeira(Cadeira c){
        this.cadeiras.remove(c);
    }

    public void addDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidades.add(disponibilidade);
        disponibilidade.setExplicador(this);
    }

    public void addIdioma(Idioma idioma) {
        this.idiomas.add(idioma);
        idioma.getExplicadores().add(this);
    }

}
