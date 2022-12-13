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
