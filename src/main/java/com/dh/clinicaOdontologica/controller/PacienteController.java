package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.dto.DentistaDTO;
import com.dh.clinicaOdontologica.entity.dto.PacienteDTO;
import com.dh.clinicaOdontologica.service.DentistaService;
import com.dh.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService; // = new PacienteService();

    @GetMapping()
    public List<PacienteDTO> buscar(){
        return pacienteService.buscar();
    }

    @PostMapping()
    public ResponseEntity salvar(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.salvar(pacienteDTO);
    }
    @GetMapping("/buscarPacienteCPF/{cpf}")
    public ResponseEntity buscarPacienteCpf(@PathVariable String cpf){
        return pacienteService.buscarPacienteCpf(cpf);
    }

    @DeleteMapping()
    public ResponseEntity deletar(@RequestParam("cpf") String cpf) {
        return pacienteService.deletar(cpf);
    }

    @PatchMapping()
    public ResponseEntity atualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.atualizarPaciente(pacienteDTO);
    }
}
