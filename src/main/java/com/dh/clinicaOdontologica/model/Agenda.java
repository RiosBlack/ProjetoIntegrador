package com.dh.clinicaOdontologica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Agenda {
    private int id;
    //private LocalDateTime dataDisponivel;
    private String dataDisponivel;
    private Dentista dentista;
}
