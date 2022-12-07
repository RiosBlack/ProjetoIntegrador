package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnderecoService {
    @Autowired
    EnderecoService enderecoService;

    public List<Endereco> buscar(){return enderecoService.buscar();}

    public Endereco salvar(Endereco endereco){
        return  enderecoService.salvar(endereco);
    }
}
