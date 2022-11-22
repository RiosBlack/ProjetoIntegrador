package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.model.Endereco;
import com.dh.clinicaOdontologica.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@Controller
public class EnderecoController {
    @Autowired
    EnderecoRepository enderecoRepository; // = new EnderecoRepository();

    @GetMapping()
    public List<Endereco> buscar(){
        return enderecoRepository.buscar();
    }

    @PostMapping()
    public Endereco salvar(@RequestBody Endereco endereco){
        return enderecoRepository.salvar(endereco);
    }
}
