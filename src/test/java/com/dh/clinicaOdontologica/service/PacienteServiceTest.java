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
//        EnderecoDTO endereco = new EnderecoDTO();
        PacienteDTO paciente = new PacienteDTO();
        mapper.registerModule(new JavaTimeModule());
        paciente.setNome("Laiane");
        paciente.setSobrenome("Barbalho");
        paciente.setCpf("06848748498");//
        paciente.setDataRegistro(LocalDate.from(LocalDateTime.now()));

//        ResponseEntity<PacienteDTO> pacienteSalvo = service.salvar(paciente);

        System.out.println(paciente);



//        Assertions.assertNotNull(pacienteSalvo.getStatusCodeValue());

    }

}
