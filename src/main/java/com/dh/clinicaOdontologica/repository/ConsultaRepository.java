package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Optional<Consulta> findByConsultaID(String consultaID);

//    Optional<Consulta> buscarConsultaID(String consultaID);
}

