package com.dh.clinicaOdontologica.service;


import com.dh.clinicaOdontologica.model.Consulta;
import com.dh.clinicaOdontologica.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository consultaRepository; // = new ConsultaRepository();

    public List<Consulta> buscar(){
        return consultaRepository.buscar();
    }

    public Consulta salvar(Consulta consulta){
        return  consultaRepository.salvar(consulta);
    }
}
