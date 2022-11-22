package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.Agenda;
import com.dh.clinicaOdontologica.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgendaService {
    @Autowired
    AgendaRepository agendaRepository; //= new AgendaRepository();

    public List<Agenda> buscar(){
        return agendaRepository.buscar();
    }

    public Agenda salvar(Agenda agenda){
        return  agendaRepository.salvar(agenda);
    }
}
