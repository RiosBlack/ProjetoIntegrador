package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {

    Optional<Dentista> findById(Long aLong);

    List<Dentista> buscar();

    Dentista salvar(Dentista dentista);
}


//public interface DentistaRepository {
//
//
//    public static List<Dentista> listDentista = new ArrayList<>();
//
//    public List<Dentista> buscar(){
//        return listDentista;
//    }
//
//    public Dentista salvar(Dentista dentista){
//        listDentista.add(dentista);
//        return dentista;
//    }
//}
