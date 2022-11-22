package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.model.Paciente;
import com.dh.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@Controller
public class PacienteController {
    @Autowired
    PacienteService pacienteService; // = new PacienteService();

    @GetMapping()
    public List<Paciente> buscar(){
        return pacienteService.buscar();
    }

    @PostMapping()
    public Paciente salvar(@RequestBody Paciente paciente){
        return pacienteService.salvar(paciente);
    }
}
