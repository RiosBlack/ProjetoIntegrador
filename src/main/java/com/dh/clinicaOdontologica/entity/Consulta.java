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

    @Column (nullable = false, unique = true)
    private String consultaID;

    @Column (nullable = false)
    private Timestamp dataConsulta;

    @OneToOne
    @JoinColumn(name = "dentista-id")
    private Dentista dentista;

    @OneToOne
    @JoinColumn(name = "paciente-id")
    private Paciente paciente;
}
