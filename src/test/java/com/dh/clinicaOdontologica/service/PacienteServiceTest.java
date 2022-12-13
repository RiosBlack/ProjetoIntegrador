package com.dh.clinicaOdontologica.service;


import com.dh.clinicaOdontologica.entity.Usuario;
import com.dh.clinicaOdontologica.entity.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.entity.dto.PacienteDTO;
import com.dh.clinicaOdontologica.entity.dto.UsuarioDTO;
import com.dh.clinicaOdontologica.repository.EnderecoRepository;
import com.dh.clinicaOdontologica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

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

        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setUsername("laiane");
        usuario.setPassword("123456");

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
        paciente.setCpf("06848748498");
        paciente.setDataRegistro(Timestamp.from(Instant.now()));
        paciente.setEndereco(endereco);
        paciente.setUsuario(usuario);

        PacienteDTO pacienteSalvo = service.salvar(paciente);

        System.out.println(pacienteSalvo);
        System.out.println();

    }
    @Test
    void atualizarPacienteParcial(){

        EnderecoDTO endereco = new EnderecoDTO();
        endereco.setRua("Rua do cabeludo");
        endereco.setNumero(50);
        endereco.setCidade("Recife");
        endereco.setEstado("PE");
        endereco.setCep("50370-890");
        endereco.setComplemento("casa");

        EnderecoDTO enderecoSalvo = enderecoService.salvar(endereco);
        System.out.println(enderecoSalvo);

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNome("Laiane");
        pacienteDTO.setSobrenome("Barbalho");
        pacienteDTO.setCpf("06848748498");
        pacienteDTO.setDataRegistro(Timestamp.from(Instant.now()));
        pacienteDTO.setEndereco(endereco);
        PacienteDTO pacienteSalvo = service.salvar(pacienteDTO);

        System.out.println(pacienteSalvo);
        System.out.println();

        String nomePaciente = pacienteSalvo.getNome();
        log.info("o nome retornado do pacienteSalvo.getNome() eh: " + nomePaciente);

        pacienteSalvo.setNome("Bernadete");

        PacienteDTO pacienteSalvoDTO = mapper.convertValue(pacienteSalvo,PacienteDTO.class);

        PacienteDTO pacienteDTOAlterado = service.atualizarPacienteParcial(pacienteSalvoDTO);

        System.out.println(pacienteDTOAlterado.getNome());
        log.info("validacao se o paciente foi salvo");
        Assertions.assertFalse(pacienteDTOAlterado.getNome().equals(pacienteSalvo));
    }

    @Test
    void deletarPaciente() {
        EnderecoDTO endereco = new EnderecoDTO();
        endereco.setRua("Rua do cabeludo");
        endereco.setNumero(50);
        endereco.setCidade("Recife");
        endereco.setEstado("PE");
        endereco.setCep("50370-890");
        endereco.setComplemento("casa");

        EnderecoDTO enderecoSalvo = enderecoService.salvar(endereco);
        System.out.println(enderecoSalvo);

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNome("Laiane");
        pacienteDTO.setSobrenome("Barbalho");
        pacienteDTO.setCpf("06848748498");
        pacienteDTO.setDataRegistro(Timestamp.from(Instant.now()));
        pacienteDTO.setEndereco(endereco);
        PacienteDTO pacienteSalvo = service.salvar(pacienteDTO);

        System.out.println(pacienteSalvo.getCpf());

        service.deletar(pacienteSalvo.getCpf());
        ResponseEntity pacienteDeletado = service.buscarPacienteCpf(pacienteSalvo.getCpf());

        if(pacienteDeletado == null) {
            System.out.println("O paciente foi excluído");
        }
        System.out.println("Não foi possível deletar o paciente");
    }
}
