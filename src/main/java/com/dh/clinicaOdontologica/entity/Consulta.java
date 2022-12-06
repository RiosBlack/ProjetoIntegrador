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
    private long id;

    @Column (nullable = false)
    private Timestamp dataConsulta;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Long pacienteID;


    @NotBlank
    @ManyToOne
    @JoinColumn(name = "dentista_id")
    private Long dentistaID;
}
