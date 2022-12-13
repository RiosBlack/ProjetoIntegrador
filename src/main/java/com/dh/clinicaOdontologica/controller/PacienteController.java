package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.dto.PacienteDTO;
import com.dh.clinicaOdontologica.exception.CadastroInvalidoException;
import com.dh.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity salvar( @RequestBody @Valid PacienteDTO paciente) throws CadastroInvalidoException {
            PacienteDTO pacienteSalvo = pacienteService.salvar(paciente);
        if(pacienteSalvo == null){
            throw new CadastroInvalidoException("Erro ao cadastrar paciente");
        }
        return new ResponseEntity( "Paciente "+pacienteSalvo.getNome()+" criado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity atualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.atualizarPacienteTotal(pacienteDTO);
    }

//    @PatchMapping()
//    public ResponseEntity atualizarPacienteParcial(@RequestBody PacienteDTO pacienteDTO) {
//        return pacienteService.atualizarPacienteParcial(pacienteDTO);
//    }
@PatchMapping()
public ResponseEntity atualizarPacienteParcial(@RequestBody @Valid PacienteDTO pacienteDTO) throws CadastroInvalidoException {
    PacienteDTO pacienteDTOAlterado = pacienteService.atualizarPacienteParcial(pacienteDTO);
    if(pacienteDTOAlterado == null){
        throw new CadastroInvalidoException("Erro ao alterar paciente");
//        return new ResponseEntity("Erro ao alterar paciente", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity("Paciente alterado com sucesso", HttpStatus.OK);
}

    @DeleteMapping()
    public  ResponseEntity deletar(@RequestParam("cpf") String cpf){
        return pacienteService.deletar(cpf);
    }
}
