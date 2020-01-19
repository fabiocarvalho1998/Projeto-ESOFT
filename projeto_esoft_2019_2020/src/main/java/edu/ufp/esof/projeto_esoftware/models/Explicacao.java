package edu.ufp.esof.projeto_esoftware.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Explicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Explicador explicador;

    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Cadeira cadeira;


    public boolean overlaps(Explicacao e) {
        return this.isBetween(e) || e.isBetween(this) ||
                (this.dataInicio.equals(e.dataInicio) && this.dataFim.equals(e.dataFim));
    }

    private boolean isBetween(Explicacao e){
        LocalDateTime explicacaoStartTime=e.getDataInicio();
        LocalDateTime explicacaoEndTime=e.getDataFim();
        return this.isBetween(explicacaoStartTime) || this.isBetween(explicacaoEndTime);
    }
    private boolean isBetween(LocalDateTime timeToCheck){
        return this.dataInicio.isBefore(timeToCheck) && this.dataFim.isAfter(timeToCheck);
    }



    public static ExplicacaoBuilder builder() {
        return new ExplicacaoBuilder();
    }
    public static class ExplicacaoBuilder {
        private LocalDateTime dataInicio;
        private LocalDateTime dataFim;
        private Explicador explicador;
        private Aluno aluno;
        private Cadeira cadeira;

        public ExplicacaoBuilder dataInicio(LocalDateTime di) {
            this.dataInicio=di;
            return this;
        }
        public ExplicacaoBuilder dataFim(LocalDateTime df) {
            this.dataFim=df;
            return this;
        }
        public ExplicacaoBuilder explicador(Explicador e) {
            this.explicador=e;
            return this;
        }
        public ExplicacaoBuilder aluno(Aluno a) {
            this.aluno=a;
            return this;
        }
        public ExplicacaoBuilder cadeira(Cadeira c) {
            this.cadeira=c;
            return this;
        }
        public Explicacao build() {
            Explicacao e = new Explicacao();
            e.setDataInicio(dataInicio);
            e.setDataFim(dataFim);
            e.setCadeira(cadeira);
            e.setExplicador(explicador);
            e.setAluno(aluno);
            return e;
        }
    }
}
