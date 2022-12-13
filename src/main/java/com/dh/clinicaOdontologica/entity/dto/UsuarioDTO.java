package com.dh.clinicaOdontologica.entity.dto;


import com.dh.clinicaOdontologica.entity.Dentista;
import com.dh.clinicaOdontologica.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @NotBlank
    @Size(min = 6)
    private String username;
    @NotBlank
    @Size(min = 6)
    private String password;



    public UsernamePasswordAuthenticationToken converter(){
        return new UsernamePasswordAuthenticationToken(this.username,this.password);
    }
}
