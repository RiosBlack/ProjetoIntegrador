package com.dh.clinicaOdontologica.repository;
import com.dh.clinicaOdontologica.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {
    public static List<Paciente> listPaciente = new ArrayList<>();

    public List<Paciente> buscar(){
        return listPaciente;
    }

    public Paciente salvar(Paciente paciente){
        listPaciente.add(paciente);
        return paciente;
    }
}
