package com.dh.clinicaOdontologica.service;


import com.dh.clinicaOdontologica.model.Consulta;
import com.dh.clinicaOdontologica.repository.ConsultaRepository;

import java.util.List;

public class ConsultaService {

    ConsultaRepository consultaRepository = new ConsultaRepository();

    public List<Consulta> buscar(){
        return consultaRepository.buscar();
    }

    public Consulta salvar(Consulta consulta){
        return  consultaRepository.salvar(consulta);
    }
}
