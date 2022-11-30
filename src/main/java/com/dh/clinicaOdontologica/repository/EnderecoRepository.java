package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.model.Endereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public interface EnderecoRepository {

@Repository

    public static List<Endereco> listEndereco = new ArrayList<>();

    public List<Endereco> buscar(){
        return listEndereco;
    }

    public Endereco salvar(Endereco endereco) {
        listEndereco.add(endereco);
        return endereco;
    }
}
