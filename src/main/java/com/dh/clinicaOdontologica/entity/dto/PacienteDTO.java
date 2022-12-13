package com.dh.clinicaOdontologica.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Timestamp;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {
//    @JsonIgnore
//    @Id
//    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;

    private Timestamp dataRegistro;

    private EnderecoDTO endereco;

//    private UsuarioDTO usuario;
}
