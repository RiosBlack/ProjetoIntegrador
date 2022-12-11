package com.dh.clinicaOdontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    @NotBlank(message = "Campo não informado")
    private String matricula;

    @Column(nullable = false, length = 100)
    @Pattern(regexp = "[A-Z]+(.)*", message = "Primeira letra maiuscula")
    @NotBlank(message = "Campo não informado")
    private String nome;

    @Column(nullable = false, length = 100, unique = true)
    @Pattern(regexp = "[A-Z]+(.)*", message = "Primeira letra maiuscula")
    @NotBlank(message = "Campo não informado")
    private String sobrenome;
}
