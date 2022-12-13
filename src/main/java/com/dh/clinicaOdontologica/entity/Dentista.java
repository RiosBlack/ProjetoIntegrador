package com.dh.clinicaOdontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "Campo não informado")
    private String nome;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Campo não informado")
    private String sobrenome;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}