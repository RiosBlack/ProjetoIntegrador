package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository; //= new PacienteRepository();

    public List<Paciente> buscar(){
        return pacienteRepository.findAll();
    }

    public Paciente salvar(Paciente paciente){
        return  pacienteRepository.save(paciente);
    }
}
