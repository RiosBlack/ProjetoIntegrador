package com.dh.clinicaOdontologica.service;


import com.dh.clinicaOdontologica.entity.Consulta;
import com.dh.clinicaOdontologica.entity.Dentista;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.dto.ConsultaDTO;
import com.dh.clinicaOdontologica.repository.ConsultaRepository;
import com.dh.clinicaOdontologica.repository.DentistaRepository;
import com.dh.clinicaOdontologica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j
@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    DentistaRepository dentistaRepository;

    @Autowired
    DentistaService dentistaService;

    public List<ConsultaDTO> buscarTodasConsultas(){
        List<Consulta> listConsulta = consultaRepository.findAll();
        List<ConsultaDTO> listConsultaDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Consulta consulta : listConsulta){
            ConsultaDTO consultaDTO = mapper.convertValue(consulta, ConsultaDTO.class);
            listConsultaDTO.add(consultaDTO);
        }
        return listConsultaDTO;
    }

    public ResponseEntity buscarUnicaConsulta(String consultaID){
        ObjectMapper mapper = new ObjectMapper();
        Optional<Consulta> idConsultaColetado = consultaRepository.findByConsultaID(consultaID);
        if (idConsultaColetado.isEmpty()){
            return new ResponseEntity("Consulta não encontrada",HttpStatus.BAD_REQUEST);
        }
        Consulta consulta = idConsultaColetado.get();
        ConsultaDTO consultaDTO = mapper.convertValue(consulta, ConsultaDTO.class);
        return new ResponseEntity(consultaDTO, HttpStatus.OK);
    }

    public ResponseEntity salvar(ConsultaDTO consultaDTO) {
        try {
            String dentistaMatricula = consultaDTO.getDentista().getMatricula();
            String pacienteCpf = consultaDTO.getPaciente().getCpf();
            Optional<Paciente> paciente = pacienteRepository.findByCpf(pacienteCpf);
            Optional<Dentista> dentista = Optional.ofNullable(dentistaRepository.findByMatricula(dentistaMatricula));
            Dentista dentista1 = dentistaRepository.findByMatricula(dentistaMatricula);

            if (paciente.isEmpty()  || dentista.isEmpty() || dentista1 == null) {
                return new ResponseEntity("Dentista ou paciente não encontrado", HttpStatus.BAD_REQUEST);
            }

            if (consultaDTO.getDataConsulta().before(Timestamp.valueOf(LocalDateTime.now()))){
                return new ResponseEntity ("Data invalida", HttpStatus.BAD_REQUEST);
            }

            Consulta consulta = new Consulta();
            consulta.setDataConsulta(consultaDTO.getDataConsulta());
            consulta.setDentista(dentista.get());
            consulta.setPaciente(paciente.get());
            consulta.setConsultaID(UUID.randomUUID().toString());
            consultaRepository.save(consulta);

            log.info("Consulta salva!");
            return new ResponseEntity("Consulta salva", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Erro ao salvar consulta");
            return new ResponseEntity("Erro ao salvar consulta", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity deletar(String consultaID) {
        Optional<Consulta> consulta = consultaRepository.findByConsultaID(consultaID);
        if (consulta.isEmpty()){
            return new ResponseEntity("Consulta Inexistente",HttpStatus.BAD_REQUEST);
        }
        consultaRepository.deleteById(consulta.get().getId());
        return new ResponseEntity("Consulta excluida com sucesso", HttpStatus.OK);
    }

    public boolean validandoDataConsulta(ConsultaDTO consultaDTO) {
        Consulta consulta = consultaRepository.findByPacienteDataConsulta(consultaDTO.getPaciente().getCpf(), consultaDTO.getDataConsulta());
        Consulta consulta1 = consultaRepository.findByDentistaMatricula(consultaDTO.getDentista().getMatricula(), consultaDTO.getDataConsulta());
        if (consulta == null || consulta1 == null) {
            return false;
        }
        return true;
    }

}
