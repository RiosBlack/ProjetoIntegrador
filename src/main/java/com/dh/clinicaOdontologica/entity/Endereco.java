package com.dh.clinicaOdontologica.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Endereco{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Não pode estar vazio")
    private String cep;
    @Column(nullable = false)
    @NotBlank(message = "Não pode estar vazio")
    private String cidade;
    
    private String estado;
    private String rua;
    private int numero;
    private String complemento;

}