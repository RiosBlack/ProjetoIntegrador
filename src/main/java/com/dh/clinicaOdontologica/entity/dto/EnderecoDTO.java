package com.dh.clinicaOdontologica.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO {
    private String rua;
    private int numero;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento;
}
