package com.dh.clinicaOdontologica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Dentista {
    private int id;
    private Integer matricula;
    private String nome;
    private String sobrenome;
}
