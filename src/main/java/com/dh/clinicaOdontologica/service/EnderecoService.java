package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.entity.dto.PacienteDTO;
import com.dh.clinicaOdontologica.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j
@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<EnderecoDTO> buscar(){
        log.info("Buscando endereço");
        List<Endereco> listaEndereco = enderecoRepository.findAll();
        List<EnderecoDTO> listEnderecoDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Endereco endereco : listaEndereco){
            EnderecoDTO enderecoDTO = mapper.convertValue(endereco, EnderecoDTO.class);
            listEnderecoDTO.add(enderecoDTO);
        }
        log.info("Endereço encontrado");
        return listEnderecoDTO;
    }

    public EnderecoDTO salvar(EnderecoDTO enderecoDTO){
    ObjectMapper mapper = new ObjectMapper();
    Endereco endereco = mapper.convertValue(enderecoDTO, Endereco.class);
    try{
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        return mapper.convertValue(enderecoSalvo, EnderecoDTO.class);
    } catch (Exception e){
        return null;
    }
}
    public ResponseEntity deletar(Long id) {
        log.info("Buscando ID do endereço.");
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isEmpty()){
            log.error("Id do endereço não encontrado");
            return new ResponseEntity("Endereço não encontrado",HttpStatus.BAD_REQUEST);
        }
        log.info("Deletando endereço");
        enderecoRepository.deleteById(id);
        return new ResponseEntity("Endereço excluido", HttpStatus.OK);
    }
}
