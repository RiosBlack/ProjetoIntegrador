package com.dh.clinicaOdontologica.entity.dto;

import com.dh.clinicaOdontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO {
    @JsonIgnore
    @Id
    private int id;
    private int numero;
    private Integer cep;
    private String cidade;
    private String estado;
    private String rua;
    private String complemento;
    private Paciente paciente;
}
