package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Paciente,Long> {
    Optional<Paciente> findById(Long aLong);
}
//public interface EnderecoRepository {
//
//
//    public static List<Endereco> listEndereco = new ArrayList<>();
//
//    public List<Endereco> buscar(){
//        return listEndereco;
//    }
//
//    public Endereco salvar(Endereco endereco) {
//        listEndereco.add(endereco);
//        return endereco;
//    }
//}
