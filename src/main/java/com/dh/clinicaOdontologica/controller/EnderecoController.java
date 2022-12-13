package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.exception.CadastroInvalidoException;
import com.dh.clinicaOdontologica.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

//    @PostMapping()
//    public ResponseEntity salvar(@RequestBody EnderecoDTO enderecoDTO){
//        return enderecoService.salvar(enderecoDTO);
//    }

    @PostMapping()
    public ResponseEntity salvar( @RequestBody @Valid Endereco endereco) throws CadastroInvalidoException {
        try{
            Endereco enderecoSalvo = enderecoService.salvar(endereco);
            return new ResponseEntity( "Endereco "+enderecoSalvo.getRua()+" criado com sucesso", HttpStatus.CREATED);
        }catch (Exception e){
            throw new CadastroInvalidoException("Erro ao cadastrar endereco");
        }
    }

    @DeleteMapping()
    public ResponseEntity deletar(@RequestParam("id") Long id){ return enderecoService.deletar(id);}
}
