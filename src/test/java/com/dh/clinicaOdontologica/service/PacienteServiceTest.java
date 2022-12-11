package com.dh.clinicaOdontologica.service;


import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.entity.dto.PacienteDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class PacienteServiceTest {
    @Autowired
    PacienteService service;
    ObjectMapper mapper = new ObjectMapper();

    @Test
    void salvar(){

//        Endereco endereco = new Endereco();
//        endereco.setRua("Rua do cabeludo");
//        endereco.setNumero(50);
//        endereco.setCidade("Recife");
//        endereco.setEstado("PE");
//        endereco.setCep("50370-890");

//        Endereco enderecoSalvo = service.salvar(endereco);
//        System.out.println(endereco);

        Paciente paciente = new Paciente();
        paciente.setNome("Laiane");
        paciente.setSobrenome("Barbalho");
        paciente.setCpf("06848748498");//
        paciente.setDataRegistro(Timestamp.from(Instant.now()));
        paciente.getEndereco();

        Paciente pacienteSalvo = service.salvar(paciente);

        System.out.println(paciente);



//        Assertions.assertNotNull(pacienteSalvo.getStatusCodeValue());

    }

}
