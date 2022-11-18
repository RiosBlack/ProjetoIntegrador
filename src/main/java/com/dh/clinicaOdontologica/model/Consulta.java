package com.dh.clinicaOdontologica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Consulta {
    private int id;
    private LocalDateTime dataConsulta;
    private Boolean agenda;
    private String paciente;
    private String dentista;
}
