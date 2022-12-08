package com.dh.clinicaOdontologica.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String matricula;


    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;


    @NotBlank
    @Column(nullable = false, length = 100)
    private String sobrenome;
}
