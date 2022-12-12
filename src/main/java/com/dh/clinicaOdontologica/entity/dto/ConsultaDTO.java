package com.dh.clinicaOdontologica.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaDTO {
    private String consultaID;
    private Timestamp dataHoraConsulta;

    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private DentistaDTO dentista;
    private PacienteDTO paciente;

    public LocalDate getDataConsulta() {
        return dataHoraConsulta.toLocalDateTime().toLocalDate();
    }

    public LocalTime getHoraConsulta() {
        return dataHoraConsulta.toLocalDateTime().toLocalTime();
    }
}
