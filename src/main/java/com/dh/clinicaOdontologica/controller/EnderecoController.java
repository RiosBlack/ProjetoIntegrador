package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@Controller
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;
//    EnderecoRepository enderecoRepository; // = new EnderecoRepository();

    @GetMapping()
    public List<Endereco> buscar(){
        return enderecoService.buscar();
    }

    @PostMapping()
    public Endereco salvar(@RequestBody Endereco endereco){
        return enderecoService.salvar(endereco);
    }
}
