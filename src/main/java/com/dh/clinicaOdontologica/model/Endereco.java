package com.dh.clinicaOdontologica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private int id;
    private int numero;
    private Integer cep;
    private String cidade;
    private String estado;
    private String rua;
    private String complemento;
};
