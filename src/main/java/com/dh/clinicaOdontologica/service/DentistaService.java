package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.entity.Dentista;
import com.dh.clinicaOdontologica.entity.dto.DentistaDTO;
import com.dh.clinicaOdontologica.repository.DentistaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {
    @Autowired
    DentistaRepository dentistaRepository; // = new DentistaRepository();

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
            Dentista dentistaSalvo = dentistaRepository.save(dentista);

            return new ResponseEntity("Dentista "+dentistaSalvo.getNome() + " salvo", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity("Erro ao cadastrar Dentista", HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity deletar(Long id){
        Optional<Dentista> dentista = dentistaRepository.findById(id);
        if(dentista.isEmpty()){
            return new ResponseEntity("Id do dentista não existe",HttpStatus.NOT_FOUND);
        }dentistaRepository.deleteById(id);
        return new ResponseEntity("Dentista foi excluído com sucesso", HttpStatus.OK);
    }
}
