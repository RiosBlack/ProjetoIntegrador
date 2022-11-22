package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.Dentista;
import com.dh.clinicaOdontologica.model.dto.DentistaDTO;
import com.dh.clinicaOdontologica.repository.DentistaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class DentistaService {
    DentistaRepository dentistaRepository = new DentistaRepository();

    public List<DentistaDTO> buscar(){
        List<Dentista> listDentista = dentistaRepository.buscar();
        List<DentistaDTO> listDentistaDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Dentista dentista : listDentista) {
            DentistaDTO dentistaDTO = mapper.convertValue(dentista, DentistaDTO.class);
            listDentistaDTO.add(dentistaDTO);
        }
        return listDentistaDTO;
    }


    public ResponseEntity salvar(Dentista dentista){
        try{
            Dentista dentistaSalvo = dentistaRepository.salvar(dentista);
            return new ResponseEntity("Dentista "+dentista.getNome() + " salvo", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity("Erro ao cadastrar Dentista", HttpStatus.BAD_REQUEST);
        }
    }
}
