package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.model.Dentista;
import com.dh.clinicaOdontologica.model.dto.DentistaDTO;
import com.dh.clinicaOdontologica.service.DentistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    DentistaService dentistaService = new DentistaService();

    @GetMapping()
    public List<DentistaDTO> buscar(){
        return dentistaService.buscar();
    }

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Dentista dentista){
        return dentistaService.salvar(dentista);
    }
}
