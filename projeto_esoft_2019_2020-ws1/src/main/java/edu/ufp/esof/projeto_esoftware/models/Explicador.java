package edu.ufp.esof.projeto_esoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Explicador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "explicadores")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    //@JsonIgnore
    private Set<Idioma> idiomas = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "explicador")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    //@JsonIgnore
    private Set<Disponibilidade> disponibilidades = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Explicacao> explicacoes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    //@JsonIgnore
    private Set<Cadeira> cadeiras = new HashSet<>();



    @JsonInclude
    @ToString.Include
    public Set<String> cadeiras() {
        Set<String> names=new HashSet<>();
        for(Cadeira cadeira :this.cadeiras){
            names.add(cadeira.getNome());
        }
        return names;
    }


    public void update(Explicador explicador) {
        this.setExplicacoes(explicador.getExplicacoes());
        this.setCadeiras(explicador.getCadeiras());
    }


    public void addExplicacao(Explicacao e){
        this.explicacoes.add(e);
        e.setExplicador(this);
        Aluno aluno = e.getAluno();
        if(aluno !=null && !aluno.getExplicacoes().contains(e)){
            aluno.addExplicacao(e);
        }
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



    public boolean temhorario(Integer diasem, LocalTime horaInicio){
        for(Disponibilidade d: disponibilidades){
            if(d.getDiaSemana().getValue()==diasem){
                if(horaInicio.isAfter(d.getHoraInicio())&&horaInicio.isBefore(d.getHoraFim()))return true;
            }
        }
        return false;
    }

    public boolean temExplicacao(Explicacao e){
        LocalDateTime hfim = e.getDataInicio().plusMinutes(30);
        for(Explicacao e1: explicacoes){
            if(e1.overlaps(e))return true; //já tem uma consulta marcada
        }
        return false; // nao tem nenhuma consulta marcada nessa hora
    }


    public static ExplicadorBuilder builder() {
        return new ExplicadorBuilder();
    }
    public static class ExplicadorBuilder {
        private long id;
        private String nome;

        public ExplicadorBuilder nome(String nome) {
            this.nome=nome;
            return this;
        }
        public Explicador build() {
            Explicador e = new Explicador();
            e.setNome(nome);
            return e;
        }
    }
}

