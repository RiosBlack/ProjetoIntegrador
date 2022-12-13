package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.dto.PacienteDTO;
import com.dh.clinicaOdontologica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

//    static final Logger log = Logger.getLogger(PacienteService.class);


    public List<PacienteDTO> buscarTodos(){
        List<Paciente> listaPacientes = pacienteRepository.findAll();
        List<PacienteDTO> listPacienteDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Paciente paciente : listaPacientes){
            PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
                listPacienteDTO.add(pacienteDTO);
            }
        return listPacienteDTO;
    }

    public PacienteDTO salvar(PacienteDTO pacienteDTO){
        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        try{
            paciente.setDataRegistro(Timestamp.from(Instant.now()));
            Paciente pacienteSalvo = pacienteRepository.save(paciente);
            return mapper.convertValue(pacienteSalvo, PacienteDTO.class);
        } catch (Exception e){
            return null;
        }
    }



    public ResponseEntity buscarPacienteCpf(String cpf) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Paciente> paciente = pacienteRepository.findByCpf(cpf);
        if (paciente.isEmpty()){
            return new ResponseEntity("Paciente não encontrado", HttpStatus.BAD_REQUEST);
        }
        Paciente pacienteGet = paciente.get();
        PacienteDTO pacienteDTO = mapper.convertValue(pacienteGet, PacienteDTO.class);
        return new ResponseEntity(pacienteDTO, HttpStatus.CREATED);
    }

    public ResponseEntity atualizarPacienteTotal(PacienteDTO pacienteDTO) {
        Optional<Paciente> pacienteCPF = pacienteRepository.findByCpf(pacienteDTO.getCpf());
        if (pacienteCPF.isEmpty()){
            return new ResponseEntity("O paciente não foi encontrado", HttpStatus.BAD_REQUEST);
        }
        Paciente pacienteAtualizado = pacienteCPF.get();
        pacienteAtualizado.setNome(pacienteDTO.getNome());
        pacienteAtualizado.setSobrenome(pacienteDTO.getSobrenome());
        pacienteRepository.save(pacienteAtualizado);
        return new ResponseEntity("Paciente " + pacienteAtualizado.getNome() + " atualizado com sucesso", HttpStatus.OK);
    }
public PacienteDTO atualizarPacienteParcial(PacienteDTO pacienteDTO){
    ObjectMapper mapper = new ObjectMapper();
    Optional<Paciente> pacienteOptional = pacienteRepository.findByCpf(pacienteDTO.getCpf());
    PacienteDTO pacienteAlterado = null;
    if(pacienteOptional.isEmpty()){
        return pacienteAlterado;
    }
    Paciente paciente = pacienteOptional.get();
    if(pacienteDTO.getNome() != null){
        paciente.setNome(pacienteDTO.getNome());
    }
    if(pacienteDTO.getSobrenome() != null){
        paciente.setSobrenome(pacienteDTO.getSobrenome());
    }
    if(pacienteDTO.getDataRegistro() != null){
        paciente.setDataRegistro(pacienteDTO.getDataRegistro());
    }
    if(pacienteDTO.getCpf() != null){
        paciente.setCpf(pacienteDTO.getCpf());
    }

    pacienteAlterado = mapper.convertValue(pacienteRepository.save(paciente), PacienteDTO.class);

    return pacienteAlterado;
}


//    public ResponseEntity atualizarPacienteParcial(PacienteDTO pacienteDTO) {
//        ObjectMapper mapper = new ObjectMapper();
//        Optional<Paciente> pacienteCPF = pacienteRepository.findByCpf(pacienteDTO.getCpf());
//        if (pacienteCPF.isEmpty()){
//            return new ResponseEntity("O paciente não foi encontrado", HttpStatus.BAD_REQUEST);
//        }
//        Paciente pacienteAtualizado = pacienteCPF.get();
//        if (pacienteDTO.getNome() != null || !pacienteDTO.getNome().isEmpty()){
//            pacienteAtualizado.setNome(pacienteDTO.getNome());
//        }
//        if (pacienteDTO.getSobrenome() != null || !pacienteDTO.getSobrenome().isEmpty()){
//            pacienteAtualizado.setSobrenome(pacienteDTO.getSobrenome());
//        }
//        pacienteRepository.save(pacienteAtualizado);
//        return new ResponseEntity("Paciente Atualizado com sucesso", HttpStatus.OK);
//    }

    public ResponseEntity deletar(String cpf) {
        Optional<Paciente> pacienteCPF = pacienteRepository.findByCpf(cpf);
        if (pacienteCPF.isEmpty()){
            return new ResponseEntity("Paciente não encontrado", HttpStatus.BAD_REQUEST);
        }
        pacienteRepository.deleteById(Long.valueOf(pacienteCPF.get().getId()));
        return new ResponseEntity("O paciente foi excluido.", HttpStatus.OK);
    }
}
