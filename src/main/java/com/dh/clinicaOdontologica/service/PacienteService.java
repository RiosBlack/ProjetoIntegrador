package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.entity.dto.PacienteDTO;
import com.dh.clinicaOdontologica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j
@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository; //= new PacienteRepository();



    public ResponseEntity salvar(PacienteDTO pacienteDTO){
        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        try {
            pacienteRepository.save(paciente);
            log.info("Paciente salvo!");
            return new ResponseEntity<>("Consulta salva com sucesso", HttpStatus.CREATED);
        } catch (Exception e){
            log.error("Erro ao salvar endereço");
            return new ResponseEntity<>("Erro ao salvar consulta", HttpStatus.BAD_REQUEST);
        }
    }

    public List<PacienteDTO> buscar() {
    }

    public ResponseEntity buscarPacienteCpf(String cpf) {
    }

    public ResponseEntity deletar(String cpf) {
    }

    public ResponseEntity atualizarPaciente(PacienteDTO pacienteDTO) {
    }
}
