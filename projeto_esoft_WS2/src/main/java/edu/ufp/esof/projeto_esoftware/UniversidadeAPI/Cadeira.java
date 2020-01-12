package edu.ufp.esof.projeto_esoftware.UniversidadeAPI;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Cadeira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    //@JsonIgnore
    @JsonBackReference(value = "cursoCadeiras")
    private Curso curso;

    @OneToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Explicacao> explicacoes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "cadeiras")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Explicador> explicadores = new HashSet<>();



    public void addExplicador(Explicador explicador){
        this.explicadores.add(explicador);
        explicador.getCadeiras().add(this);
    }

    public void removeExplicador(Explicador e){
        this.explicadores.remove(e);
    }

    public void addExplicacao(Explicacao explicacao){
        this.explicacoes.add(explicacao);
        explicacao.setCadeira(this);
    }

    public void removeExplicacao(Explicacao e){
        this.explicacoes.remove(e);
    }

    @JsonInclude
    //@JsonProperty(value = "curso")
    public String getCursoNome(){
        return this.curso==null?"null":this.curso.getNome();
    }




    public static CadeiraBuilder builder() {
        return new CadeiraBuilder();
    }

    public static class CadeiraBuilder {
        private long id;
        private String nome;

        public CadeiraBuilder nome(String nome) {
            this.nome=nome;
            return this;
        }
        public Cadeira build() {
            Cadeira c = new Cadeira();
            c.setNome(nome);
            return c;
        }
    }
}
