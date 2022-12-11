package com.dh.clinicaOdontologica.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 9)
    private String cep;
    @Column(nullable = false)
    @Pattern(regexp = "[A-Z]+(.)*")
    private String cidade;
    
    private String estado;
    private String rua;
    private String complemento;

}


