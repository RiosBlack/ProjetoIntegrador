package com.dh.clinicaOdontologica.repository;
import com.dh.clinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
//    Optional<Paciente> buscarPorCpf(String cpf);

    Optional<Paciente> findByCpf(String cpf);


}

