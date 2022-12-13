package com.dh.clinicaOdontologica.entity;


import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
//@Table
public class Paciente  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Campo não informado")
    private String nome;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Campo não informado")
    private String sobrenome;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Campo não informado")
    @CPF(message = "Campo inválido")
    private String cpf;


    @Column(nullable = false)
    private Timestamp dataRegistro;


    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Usuario usuario;
}
