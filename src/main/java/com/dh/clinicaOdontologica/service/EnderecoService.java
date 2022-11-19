package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.Endereco;

import java.util.List;

public class EnderecoService {
    EnderecoService enderecoService = new EnderecoService();

    public List<Endereco> buscar(){
        return enderecoService.buscar();
    }

    public Endereco salvar(Endereco endereco){
        return  enderecoService.salvar(endereco);
    }
}
