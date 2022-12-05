package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
//public interface ConsultaRepository {
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    public static List<Consulta> listConsulta = new ArrayList<>();

    Consulta salvar(Consulta consulta);

    List<Consulta> buscar();
}


//    public List<Consulta> buscar(){
//        return listConsulta;
//    }


//    public Consulta salvar(Consulta consulta){
//        listConsulta.add(consulta);
//        return consulta;
//    }

