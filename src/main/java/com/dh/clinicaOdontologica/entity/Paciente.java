package com.dh.clinicaOdontologica.entity;


import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 100)
    private String sobrenome;
    @Column(nullable = false)
    @CPF
    private Integer cpf;
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    //private LocalDateTime dataRegistro;
    @Column(nullable = false)
    private Timestamp dataRegistro; //data que foi marcada a consulta

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
