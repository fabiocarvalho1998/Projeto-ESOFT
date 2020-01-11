package edu.ufp.esof.projeto_esoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
}

