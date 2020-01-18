package edu.ufp.esof.projeto_esoftware.services.filters.explicador;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

@Data
public class FilterExplicadorObject {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String nome;
    private String cadeira;
    private String idioma;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dia;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime inicio;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime fim;

    public FilterExplicadorObject(Map<String, String> params) {
        this.nome = params.get("nome");
        this.cadeira = params.get("cadeira");
        this.idioma = params.get("idioma");

        String diaString = params.get("dia");
        String horaInicioString = params.get("inicio");
        String horaFimString = params.get("fim");

        try {
            dia = LocalDate.parse(diaString);
            inicio = LocalTime.parse(horaInicioString);
            fim = LocalTime.parse(horaFimString);
        } catch (Exception e) {
            this.logger.error(e.getMessage());
        }


    }
}
