package com.dh.clinicaOdontologica.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 9)
    private String cep;
    @Column(nullable = false)
    private String cidade;
    private String estado;
    private String rua;
    private String complemento;

}


