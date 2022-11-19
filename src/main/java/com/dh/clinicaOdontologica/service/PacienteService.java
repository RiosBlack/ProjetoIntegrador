package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.Paciente;
import com.dh.clinicaOdontologica.repository.PacienteRepository;

import java.util.List;

public class PacienteService {
    PacienteRepository pacienteRepository = new PacienteRepository();

    public List<Paciente> buscar(){
        return pacienteRepository.buscar();
    }

    public Paciente salvar(Paciente paciente){
        return  pacienteRepository.salvar(paciente);
    }
}
