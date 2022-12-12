package com.dh.clinicaOdontologica.service;


import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.dto.PacienteDTO;
import com.dh.clinicaOdontologica.repository.EnderecoRepository;
import com.dh.clinicaOdontologica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootTest
public class PacienteServiceTest {
    @Autowired
    PacienteService service;
    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

//    Logger log = Logger.getLogger(PacienteServiceTest.class);

    @Test
    void salvar(){
        Endereco endereco = new Endereco();
        endereco.setRua("Rua do cabeludo");
        endereco.setNumero(50);
        endereco.setCidade("Recife");
        endereco.setEstado("PE");
        endereco.setCep("50370-890");
        endereco.setComplemento("casa");

        Endereco enderecoSalvo = enderecoRepository.save(endereco);
//        log.info("Endereco foi salvo com sucesso");
        System.out.println(enderecoSalvo);

        Paciente paciente = new Paciente();
        paciente.setNome("Laiane");
        paciente.setSobrenome("Barbalho");
        paciente.setCpf("06848748498");//
        paciente.setDataRegistro(Timestamp.from(Instant.now()));
        paciente.setEndereco(endereco);
        Paciente pacienteSalvo = pacienteRepository.save(paciente);

        System.out.println(paciente);
        System.out.println();
        Assertions.assertNotNull(paciente.getId());
    }
    @Test
    void atualizarPacienteParcial(){

        //Criando paciente
        Endereco endereco1 = new Endereco();
        endereco1.setRua("Rua do cabeludo");
        endereco1.setNumero(50);
        endereco1.setCidade("Recife");
        endereco1.setEstado("PE");
        endereco1.setCep("50370-890");
        endereco1.setComplemento("casa");



        Endereco enderecoSalvo1 = enderecoRepository.save(endereco1);
        System.out.println(enderecoSalvo1);

        Paciente paciente = new Paciente();
        paciente.setNome("Laiane");
        paciente.setSobrenome("Barbalho");
        paciente.setCpf("06848748498");//
        paciente.setDataRegistro(Timestamp.from(Instant.now()));
        paciente.setEndereco(enderecoSalvo1);
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
