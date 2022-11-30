package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.model.Dentista;

import java.util.ArrayList;
import java.util.List;

public interface DentistaRepository {
    public static List<Dentista> listDentista = new ArrayList<>();

    public List<Dentista> buscar(){
        return listDentista;
    }

    public Dentista salvar(Dentista dentista){
        listDentista.add(dentista);
        return dentista;
    }
}
