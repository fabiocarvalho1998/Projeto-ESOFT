package edu.ufp.esof.projeto_esoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Explicacao {
    @ManyToOne(fetch = FetchType.LAZY)
    private Explicador explicador;

    @ManyToOne(fetch = FetchType.LAZY)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cadeira cadeira;


}
