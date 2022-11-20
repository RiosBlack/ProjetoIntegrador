package com.dh.clinicaOdontologica.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private int id;
    private String nome;
    private String sobrenome;
    private Integer rg;
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    //private LocalDateTime dataRegistro;
    private String dataRegistro;
}
