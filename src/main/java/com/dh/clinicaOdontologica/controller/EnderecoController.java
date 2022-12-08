package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
