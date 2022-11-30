package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.model.Endereco;

import java.util.ArrayList;
import java.util.List;

public interface EnderecoRepository {
    public static List<Endereco> listEndereco = new ArrayList<>();

    public List<Endereco> buscar(){
        return listEndereco;
    }

    public Endereco salvar(Endereco endereco) {
        listEndereco.add(endereco);
        return endereco;
    }
}
