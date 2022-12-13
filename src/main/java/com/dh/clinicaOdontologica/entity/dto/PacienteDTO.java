package com.dh.clinicaOdontologica.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import javax.validation.constraints.NotBlank;

import java.sql.Timestamp;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private String nome;
    private String sobrenome;
    private String cpf;
    private Timestamp dataRegistro;
    private EnderecoDTO endereco;

    private UsuarioDTO usuario;

}
