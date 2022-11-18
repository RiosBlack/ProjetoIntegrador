package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.Dentista;
import com.dh.clinicaOdontologica.repository.DentistaRepository;

import java.util.List;

public class DentistaService {
    DentistaRepository dentistaRepository = new DentistaRepository();

    public List<Dentista> buscar(){
        return dentistaRepository.buscar();
    }

    public Dentista salvar(Dentista dentista){
        return  dentistaRepository.salvar(dentista);
    }
}
