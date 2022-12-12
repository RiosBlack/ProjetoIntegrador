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
//@ToString
@Entity
//@Table
public class Paciente  {
    //    private static final long serialVersionUID= 1L; //teste laiane
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable = false, length = 100)
//    @Pattern(regexp = "[A-Z]+(.)", message = "Primeira letra maiuscula")
    @NotBlank(message = "Campo não informado")
    private String nome;

    @Column(nullable = false, length = 100)
//    @Pattern(regexp = "[A-Z]+(.)", message = "Primeira letra maiuscula")
    @NotBlank(message = "Campo não informado")
    private String sobrenome;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Campo não informado")
    @CPF(message = "Campo inválido")
    private String cpf;

    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    //private LocalDateTime dataRegistro;
    @Column(nullable = false)
    private Timestamp dataRegistro;

    //    @ManyToOne
//    @JoinColumn(name="endereco_id")
//    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id_teste")
    private Endereco endereco;
}
