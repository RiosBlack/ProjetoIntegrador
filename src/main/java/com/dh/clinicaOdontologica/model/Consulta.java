package com.dh.clinicaOdontologica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //private LocalDateTime dataConsulta;
    private Timestamp dataConsulta;

//    private Agenda agenda;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Dentista dentista;
}
