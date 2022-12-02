package com.dh.clinicaOdontologica.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numero;
    @NotBlank
    private Integer cep;
    @NotBlank
    private String cidade;
    private String estado;
    private String rua;
    private String complemento;
    @NotBlank
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}


