package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.Agenda;
import com.dh.clinicaOdontologica.repository.AgendaRepository;

import java.util.List;

public class AgendaService {
    AgendaRepository agendaRepository = new AgendaRepository();

    public List<Agenda> buscar(){
        return agendaRepository.buscar();
    }

    public Agenda salvar(Agenda agenda){
        return  agendaRepository.salvar(agenda);
    }
}
