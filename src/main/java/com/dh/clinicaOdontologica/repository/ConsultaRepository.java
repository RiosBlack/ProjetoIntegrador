package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;


@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Optional<Consulta> findByConsultaID(String consultaID);

    @Query("SELECT c FROM Consulta c WHERE c.paciente.cpf = :cpf AND c.dataConsulta = :dataConsulta")
    Consulta findByPacienteDataConsulta(@Param("cpf") String cpf, @Param("dataConsulta") Timestamp dataConsulta);

    @Query ("SELECT c FROM Consulta c WHERE c.dentista.matricula = :matricula AND c.dataConsulta = :dataConsulta")
    Consulta findByDentistaMatricula(@Param("matricula") String matricula, @Param("dataConsulta") Timestamp dataConsulta);
}

