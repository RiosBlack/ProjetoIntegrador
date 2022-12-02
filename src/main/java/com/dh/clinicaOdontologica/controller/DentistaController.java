package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.Dentista;
import com.dh.clinicaOdontologica.entity.dto.DentistaDTO;
import com.dh.clinicaOdontologica.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentista")
@Controller
public class DentistaController {
    @Autowired
    DentistaService dentistaService; // = new DentistaService();

    @GetMapping()
    public List<DentistaDTO> buscar(){
        return dentistaService.buscar();
    }

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Dentista dentista){
        return dentistaService.salvar(dentista);
    }
}
