package edu.ufp.esof.projeto_esoftware.UniversidadeAPI;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@Entity
public class Disponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime horaInicio;
    private LocalTime horaFim;
    private DayOfWeek diaSemana;


    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Explicador explicador;

    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    //@JsonBackReference(value = "universidadeDisponibilidades")

    private Universidade universidade;


    public boolean contains(Explicacao e){
        DayOfWeek dayOfWeek= e.getDataInicio().getDayOfWeek();
        if(dayOfWeek.equals(this.diaSemana)){
            LocalTime appointmentStart= e.getDataInicio().toLocalTime();
            LocalTime appointmentEnd= e.getDataFim().toLocalTime();
            return this.contains(appointmentStart,appointmentEnd);
        }
        return false;
    }

    private boolean contains(LocalTime start, LocalTime end){
        return (this.horaInicio.isAfter(start) || this.horaInicio.equals(start))
                &&
                (this.horaFim.isBefore(end) || this.horaFim.equals(end)) ;
    }



    @JsonInclude
    //@JsonProperty(value = "universidade")
    public String getUniversidadeNome(){
        return this.universidade==null?"null":this.universidade.getNome();
    }



    public static DisponibilidadeBuilder builder() {
        return new DisponibilidadeBuilder();
    }
    public static class DisponibilidadeBuilder {
        private LocalTime horaInicio;
        private LocalTime horaFim;
        private DayOfWeek diaSemana;
        private Explicador explicador;

        public DisponibilidadeBuilder horaInicio(LocalTime hi) {
            this.horaInicio=hi;
            return this;
        }
        public DisponibilidadeBuilder horaFim(LocalTime hf) {
            this.horaFim=hf;
            return this;
        }
        public DisponibilidadeBuilder diaSemana(DayOfWeek d) {
            this.diaSemana=d;
            return this;
        }
        public DisponibilidadeBuilder explicador(Explicador e) {
            this.explicador=e;
            return this;
        }
        public Disponibilidade build() {
            Disponibilidade d = new Disponibilidade();
            d.setHoraInicio(horaInicio);
            d.setHoraFim(horaFim);
            d.setDiaSemana(diaSemana);
            d.setExplicador(explicador);
            return d;
        }
    }
}

