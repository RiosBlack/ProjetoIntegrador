package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;

    @GetMapping()
    public List<EnderecoDTO> buscar(){
        return enderecoService.buscar();
    }

    @PostMapping()
    public ResponseEntity salvar(@RequestBody EnderecoDTO enderecoDTO){
        return enderecoService.salvar(enderecoDTO);
    }

    @DeleteMapping()
    public ResponseEntity deletar(@RequestParam("id") Long id){ return enderecoService.deletar(id);}


}
