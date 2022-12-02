package com.dh.clinicaOdontologica.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //private LocalDateTime dataConsulta;
    private Timestamp dataConsulta;

//    private Agenda agenda;
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;
}
