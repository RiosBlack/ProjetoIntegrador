package com.dh.clinicaOdontologica.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO {
    private String rua;
    private int numero;
    @NotBlank
    private Integer cep;
    @NotBlank
    private String cidade;
    private String estado;
    private String complemento;
}
