package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.entity.Dentista;
import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.dto.DentistaDTO;
import com.dh.clinicaOdontologica.entity.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.repository.EnderecoRepository;
import com.dh.clinicaOdontologica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Log4j
@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    PacienteRepository pacienteRepository;

    public ResponseEntity salvar(EnderecoDTO enderecoDTO){
        ObjectMapper mapper = new ObjectMapper();
        Endereco endereco = mapper.convertValue(enderecoDTO, Endereco.class);
        try {
            enderecoRepository.save(endereco);
            log.info("Endereço salvo!");
            return new ResponseEntity<>("Consulta salva com sucesso", HttpStatus.CREATED);
        } catch (Exception e){
            log.error("Erro ao salvar endereço");
            return new ResponseEntity<>("Erro ao salvar consulta", HttpStatus.BAD_REQUEST);
        }
    }

    public List<EnderecoDTO> buscar(){
        List<Endereco> listEndereco = enderecoRepository.findAll();
        List<EnderecoDTO> listEnderecoDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Endereco endereco : listEndereco) {
            EnderecoDTO enderecoDTO = mapper.convertValue(endereco, EnderecoDTO.class);
            listEnderecoDTO.add(enderecoDTO);
        }
        return listEnderecoDTO;
    }

    public ResponseEntity deletar(String cpf) {
    }

    public ResponseEntity atualizarEnderecoParcial(EnderecoDTO enderecoDTO) {
    }
}
