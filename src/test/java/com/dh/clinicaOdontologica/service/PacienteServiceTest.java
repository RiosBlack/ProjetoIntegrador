package com.dh.clinicaOdontologica.service;


import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.entity.dto.PacienteDTO;
import com.dh.clinicaOdontologica.repository.EnderecoRepository;
import com.dh.clinicaOdontologica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootTest
//@Log4j2

public class PacienteServiceTest {
    @Autowired
    PacienteService service;

    @Autowired
    EnderecoService enderecoService;

    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(PacienteServiceTest.class);

    @Test
    void salvar(){

        log.info("Criando paciente e endereço...");
        EnderecoDTO endereco = new EnderecoDTO();
        endereco.setRua("Rua do cabeludo");
        endereco.setNumero(50);
        endereco.setCidade("Recife");
        endereco.setEstado("PE");
        endereco.setCep("50370-890");
        endereco.setComplemento("casa");

        EnderecoDTO enderecoSalvo = enderecoService.salvar(endereco);
        log.info("Endereco foi salvo com sucesso");
        System.out.println(enderecoSalvo);

        PacienteDTO paciente = new PacienteDTO();
        paciente.setNome("Laiane");
        paciente.setSobrenome("Barbalho");
        paciente.setCpf("06848748498");//
        paciente.setDataRegistro(Timestamp.from(Instant.now()));
        paciente.setEndereco(endereco);
        PacienteDTO pacienteSalvo = service.salvar(paciente);

        System.out.println(pacienteSalvo);
        System.out.println();


//        Assertions.assertNotNull(pacienteSalvo.getId());
    }
    @Test
    void atualizarPacienteParcial(){


        Endereco endereco1 = new Endereco();
        endereco1.setRua("Rua do cabeludo");
        endereco1.setNumero(50);
        endereco1.setCidade("Recife");
        endereco1.setEstado("PE");
        endereco1.setCep("50370-890");
        endereco1.setComplemento("casa");



        Endereco enderecoSalvo = enderecoRepository.save(endereco1);
        System.out.println(enderecoSalvo);

        Paciente paciente = new Paciente();
        paciente.setNome("Laiane");
        paciente.setSobrenome("Barbalho");
        paciente.setCpf("06848748498");//
        paciente.setDataRegistro(Timestamp.from(Instant.now()));
        paciente.setEndereco(enderecoSalvo);
        Paciente pacienteSalvo = pacienteRepository.save(paciente);

        System.out.println(paciente);

        //Alterando nome do paciente
        String nomePaciente = pacienteSalvo.getNome();
        pacienteSalvo.setNome("Bernadete");
        System.out.println(paciente);

        //Convertendo produto para produtoDTO
        PacienteDTO pacienteSalvoDTO = mapper.convertValue(paciente,PacienteDTO.class);

        //Salvando a alteração do produto
        PacienteDTO pacienteDTOAlterado = service.atualizarPacienteParcial(pacienteSalvoDTO);

        System.out.println();
        //Validando a alterção do produto
//        Assertions.assertFalse(produtoDTOAlterado.getNome().equals(nomeProduto));

    }


}
