package com.dh.clinicaOdontologica.entity.dto;

import com.dh.clinicaOdontologica.entity.Consulta;
import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {
//    @JsonIgnore
//    @Id
    private int id;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String cpf;

    private Timestamp dataRegistro;
    private EnderecoDTO endereco;
//    private LocalDate dataRegistro;
//    private LocalTime horaRegistro;
    private UsuarioDTO usuarioDTO;
}
