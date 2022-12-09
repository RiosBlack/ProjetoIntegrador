package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.dto.PacienteDTO;
import com.dh.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @GetMapping()
    public List<PacienteDTO> buscar(){
        return pacienteService.buscarTodos();
    }

    @GetMapping("buscarPaciente/{cpf}")
    public ResponseEntity buscarPacienteCpf(@PathVariable String cpf){
        return pacienteService.buscarPacienteCpf(cpf);
    }

    @PostMapping()
    public ResponseEntity salvar(@RequestBody @Valid PacienteDTO pacienteDTO){
        return pacienteService.salvar(pacienteDTO);
    }

    @PutMapping()
    public ResponseEntity atualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.atualizarPacienteTotal(pacienteDTO);
    }

    @PatchMapping()
    public ResponseEntity atualizarPacienteParcial(@RequestBody PacienteDTO pacienteDTO) {
        return pacienteService.atualizarPacienteParcial(pacienteDTO);
    }

    @DeleteMapping()
    public  ResponseEntity deletar(@RequestParam("cpf") String cpf){
        return pacienteService.deletar(cpf);
    }
}
