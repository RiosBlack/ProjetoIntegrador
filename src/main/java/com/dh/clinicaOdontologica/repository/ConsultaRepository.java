package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.model.Consulta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ConsultaRepository {
    public static List<Consulta> listConsulta = new ArrayList<>();

    public List<Consulta> buscar(){
        return listConsulta;
    }

    public Consulta salvar(Consulta consulta){
        listConsulta.add(consulta);
        return consulta;
    }
}
