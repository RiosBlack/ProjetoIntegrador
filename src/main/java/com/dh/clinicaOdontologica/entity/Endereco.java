package com.dh.clinicaOdontologica.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @Column(nullable = false, length = 10)
    private String cep;
    @Column(nullable = false)
    private String cidade;
    private String estado;
    private String rua;
    private int numero;
    private String complemento;

//    @OneToMany
//    @JoinTable(name = "paciente_endereco",
//    joinColumns = @JoinColumn(name="paciente_id"),
//    inverseJoinColumns = @JoinColumn(name="enderecos_id"))
//    private List<Paciente> pacientes;

    @OneToMany(targetEntity = Paciente.class)
    private List pacienteLista;
}


