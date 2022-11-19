package com.dh.clinicaOdontologica.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private int id;
    private String nome;
    private String sobrenome;
    private Integer rg;
    private LocalDateTime dataRegistro;
}
