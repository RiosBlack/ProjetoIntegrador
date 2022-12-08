package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.dto.DentistaDTO;
import com.dh.clinicaOdontologica.entity.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.service.DentistaService;
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
//    EnderecoRepository enderecoRepository; // = new EnderecoRepository();

    @GetMapping()
    public List<EnderecoDTO> buscar(){
        return enderecoService.buscar();
    }



    @PostMapping()
    public ResponseEntity salvar(@RequestBody EnderecoDTO enderecoDTO) {
        return enderecoService.salvar(enderecoDTO);
    }

    @DeleteMapping()
    public ResponseEntity deletar(@RequestParam("cpf") String cpf) {
        return enderecoService.deletar(cpf);
    }

    @PatchMapping()
    public ResponseEntity atualizarEnderecoParcial(@RequestBody EnderecoDTO enderecoDTO){
        return enderecoService.atualizarEnderecoParcial(enderecoDTO);
    }
}
