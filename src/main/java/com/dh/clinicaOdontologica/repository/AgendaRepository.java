package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.model.Agenda;

import java.util.ArrayList;
import java.util.List;

public class AgendaRepository {
    public static List<Agenda> listAgenda = new ArrayList<>();

    public List<Agenda> buscar(){
        return listAgenda;
    }

    public Agenda salvar(Agenda agenda){
        listAgenda.add(agenda);
        return agenda;
    }
}
