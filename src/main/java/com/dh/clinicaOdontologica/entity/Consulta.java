package com.dh.clinicaOdontologica.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false, unique = true)
    private Long id;

    @Column (nullable = false)
    private Timestamp dataConsulta;

    @OneToOne
    @JoinColumn(name = "paciente-id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "dentista-id")
    private Dentista dentista;


}
