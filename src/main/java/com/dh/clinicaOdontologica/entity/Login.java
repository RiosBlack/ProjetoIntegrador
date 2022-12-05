package com.dh.clinicaOdontologica.entity;

import lombok.*;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

//@Entity
public class Login {
    private String usuario;
    private String funcao;
    private String senha;
}
