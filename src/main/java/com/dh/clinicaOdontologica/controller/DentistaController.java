package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.dto.DentistaDTO;
import com.dh.clinicaOdontologica.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dentista")
@Controller
public class DentistaController {
    @Autowired
    DentistaService dentistaService;

    @GetMapping()
    public List<DentistaDTO> buscar(){
        return dentistaService.buscar();
    }

    @GetMapping("/buscarDentistaMatricula/{matricula}")
    public ResponseEntity buscarDentistaMatricula(@PathVariable String matricula){
        return dentistaService.buscarDentistaMatricula(matricula);
    }

    @PostMapping()
    public ResponseEntity salvar(@RequestBody DentistaDTO dentistaDTO) {
        return dentistaService.salvar(dentistaDTO);
    }

    @DeleteMapping()
    public ResponseEntity deletar(@RequestParam("matricula") String matricula) {
        return dentistaService.deletar(matricula);
    }

    @PatchMapping()
    public ResponseEntity atulizarParcial(@RequestBody DentistaDTO dentistaDTO){
        return dentistaService.atulizarDentistaParcial(dentistaDTO);
    }



}
