package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.entity.Dentista;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.dto.DentistaDTO;
import com.dh.clinicaOdontologica.repository.DentistaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
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
public class DentistaService {
    @Autowired
    DentistaRepository dentistaRepository;
    static final Logger log = Logger.getLogger(DentistaService.class);

    public List<DentistaDTO> buscar(){
        List<Dentista> listDentista = dentistaRepository.findAll();
        List<DentistaDTO> listDentistaDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Dentista dentista : listDentista) {
            DentistaDTO dentistaDTO = mapper.convertValue(dentista, DentistaDTO.class);
            listDentistaDTO.add(dentistaDTO);
        }
        return listDentistaDTO;
    }


//    public ResponseEntity salvar(DentistaDTO dentistaDTO) {
//        ObjectMapper mapper = new ObjectMapper();
//        Dentista dentista = mapper.convertValue(dentistaDTO, Dentista.class);
//        try {
//            Dentista dentistaRepoSalvo = dentistaRepository.save(dentista);
//            return new ResponseEntity("Dentista " + dentista.getNome() + " Salvo",HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity("Erro ao cadastrar o dentista",HttpStatus.BAD_REQUEST);
//        }
//    }

    public Dentista salvar(Dentista dentista) {
        Dentista dentistaSalvo = dentistaRepository.save(dentista);
        return dentistaSalvo;
    }

    public ResponseEntity buscarDentistaMatricula(String matricula) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Dentista> dentista = Optional.ofNullable(dentistaRepository.findByMatricula(matricula));
        if (dentista.isEmpty()){
            log.info("Matricula não encontrada");
            return new ResponseEntity("Matricula do dentista não encontrado", HttpStatus.BAD_REQUEST);
        }
        DentistaDTO dentistaDTO = mapper.convertValue(dentista.get(), DentistaDTO.class);
        log.info("Matricula do dentista localizada.");
        return new ResponseEntity<>(dentistaDTO, HttpStatus.OK);
    }
    public ResponseEntity deletar(String matricula){
        Optional<Dentista> dentista = Optional.ofNullable(dentistaRepository.findByMatricula(matricula));
        if(dentista.isEmpty()){
            log.info("Matricula não encontrada");
            return new ResponseEntity("Matricula do dentista não encontrado",HttpStatus.NOT_FOUND);
        }
        dentistaRepository.deleteById(Long.valueOf(dentista.get().getId()));
        log.info("Dentista excluído");
        return new ResponseEntity("Dentista foi excluído com sucesso", HttpStatus.OK);
    }




    public ResponseEntity atulizarDentistaParcial(DentistaDTO dentistaDTO) {
        Optional<Dentista> dentista = Optional.ofNullable(dentistaRepository.findByMatricula(dentistaDTO.getMatricula()));
        if (dentista.isEmpty()){
            return new ResponseEntity("Matricula do dentista não encontrado",HttpStatus.BAD_REQUEST);
        }
        Dentista dentistaAtualizado = dentista.get();

        if (dentistaAtualizado.getNome().isEmpty() || dentistaAtualizado.getNome() == null){
            return new ResponseEntity("O nome não pode ser nulo ou vazio",HttpStatus.BAD_REQUEST);
        }
        if (dentistaAtualizado.getSobrenome().isEmpty() || dentistaAtualizado.getSobrenome() == null){
            return new ResponseEntity("O sobrenome não pode ser nulo ou vazio",HttpStatus.BAD_REQUEST);
        }
        dentistaAtualizado.setNome(dentistaDTO.getNome());
        dentistaAtualizado.setSobrenome(dentistaDTO.getSobrenome());
        dentistaRepository.save(dentistaAtualizado);

        return new ResponseEntity("Dentista " + dentistaDTO.getNome() + " atualizado.", HttpStatus.OK);
    }
}
