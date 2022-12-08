package com.dh.clinicaOdontologica.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import java.sql.Timestamp;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

//@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String isAdmin;
    @Column(nullable = false)
    private String password;
}
