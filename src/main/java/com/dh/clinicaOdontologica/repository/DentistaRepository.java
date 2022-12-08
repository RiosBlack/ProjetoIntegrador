package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {

    Dentista findByMatricula(String matricula);

}

