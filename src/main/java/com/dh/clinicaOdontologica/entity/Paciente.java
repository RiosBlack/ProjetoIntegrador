package com.dh.clinicaOdontologica.entity;


import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable = false, length = 100)
    @Pattern(regexp = "[A-Z]+(.)*", message = "Primeira letra maiuscula")
    @NotBlank(message = "Campo não informado")
    private String nome;

    @Column(nullable = false, length = 100)
    @Pattern(regexp = "[A-Z]+(.)*", message = "Primeira letra maiuscula")
    @NotBlank(message = "Campo não informado")
    private String sobrenome;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Campo não informado")
    @CPF(message = "Campo inválido")
    private String cpf;
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    //private LocalDateTime dataRegistro;
    @Column(nullable = false)
    private Timestamp dataRegistro; //data que foi marcada a consulta

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
