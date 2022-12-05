package com.dh.clinicaOdontologica.repository;
import com.dh.clinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findById(Long aLong);

    List<Paciente> buscar();

    Paciente salvar(Paciente paciente);
}

//public interface PacienteRepository {
//
//
//    public static List<Paciente> listPaciente = new ArrayList<>();
//
//    public List<Paciente> buscar(){
//        return listPaciente;
//    }
//
//    public Paciente salvar(Paciente paciente){
//        listPaciente.add(paciente);
//        return paciente;
//    }
//}
