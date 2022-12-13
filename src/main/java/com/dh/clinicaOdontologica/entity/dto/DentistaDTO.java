package com.dh.clinicaOdontologica.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistaDTO {
    @NotBlank(message = "Campo não informado")
    private String matricula;
    @NotBlank(message = "Campo não informado")
    private String nome;
    @NotBlank(message = "Campo não informado")
    private String sobrenome;
    private UsuarioDTO usuario;
}
