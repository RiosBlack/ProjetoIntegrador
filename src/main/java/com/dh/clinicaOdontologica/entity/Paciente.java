package com.dh.clinicaOdontologica.entity;


import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 100)
    private String sobrenome;
    @Column(nullable = false)
    @CPF
    private String cpf;
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    //private LocalDateTime dataRegistro;
    @Column(nullable = false)
    private Timestamp dataRegistro; //data que foi marcada a consulta

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
