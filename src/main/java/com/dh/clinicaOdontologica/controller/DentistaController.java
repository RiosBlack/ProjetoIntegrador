package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.model.Dentista;
import com.dh.clinicaOdontologica.service.DentistaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    DentistaService dentistaService = new DentistaService();

    @GetMapping()
    public List<Dentista> buscar(){
        return dentistaService.buscar();
    }

    @PostMapping()
    public Dentista salvar(@RequestBody Dentista dentista){
        return dentistaService.salvar(dentista);
    }
}
