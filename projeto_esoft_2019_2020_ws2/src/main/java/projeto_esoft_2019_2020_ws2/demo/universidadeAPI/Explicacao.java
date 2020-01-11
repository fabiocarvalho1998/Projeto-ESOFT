package projeto_esoft_2019_2020_ws2.demo.universidadeAPI;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
}
