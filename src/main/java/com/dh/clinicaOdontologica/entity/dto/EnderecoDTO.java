package com.dh.clinicaOdontologica.entity.dto;

import com.dh.clinicaOdontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO {
    private String rua;
    private int numero;
    private Integer cep;
    private String cidade;
    private String estado;
    private String complemento;
}
