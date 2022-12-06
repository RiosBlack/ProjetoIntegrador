package com.dh.clinicaOdontologica.service;


import com.dh.clinicaOdontologica.entity.Consulta;
import com.dh.clinicaOdontologica.entity.dto.ConsultaDTO;
import com.dh.clinicaOdontologica.repository.ConsultaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository consultaRepository; // = new ConsultaRepository();

    public List<ConsultaDTO> buscar(){
        List<Consulta> listConsulta = consultaRepository.findAll();
        List<ConsultaDTO> listConsultaDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Consulta consulta : listConsulta){
            ConsultaDTO consultaDTO = mapper.convertValue(consulta, ConsultaDTO.class);
            listConsultaDTO.add(consultaDTO);
        }
        return listConsultaDTO;
    }
   public ResponseEntity salvar(ConsultaDTO consultaDTO){ return  consultaRepository.save(consultaDTO);}

    //public ResponseEntity deletar (ConsultaDTO consultaDTO){ return consultaRepository.delete();}
}
