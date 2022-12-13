package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.Consulta;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.dto.ConsultaDTO;
import com.dh.clinicaOdontologica.exception.CadastroInvalidoException;
import com.dh.clinicaOdontologica.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @GetMapping()
    public List<ConsultaDTO> buscarTodasConsultas(){
        return consultaService.buscarTodasConsultas();
    }

    @GetMapping("/BuscarConsultaEspecifica/{consultaID}")
    public ResponseEntity buscarUnicaConsulta(@PathVariable String consultaID){
        return consultaService.buscarUnicaConsulta(consultaID);
    }

    @PostMapping()
    public ResponseEntity salvar(@RequestBody @Valid ConsultaDTO consultaDTO){
        return consultaService.salvar(consultaDTO);
    }
//@PostMapping()
//public ResponseEntity salvar( @RequestBody @Valid Consulta consulta) throws CadastroInvalidoException {
//    try{
//        Consulta consultaSalva = consultaService.salvar(consulta);
//        return new ResponseEntity( "Consulta marcada para o paciente: "+consultaSalva.getDataConsulta(), HttpStatus.CREATED);
//    }catch (Exception e){
//        throw new CadastroInvalidoException("Erro ao marcar consulta");
//    }
//}
    
    @DeleteMapping()
    public ResponseEntity deletar (@RequestParam("consultaID") String consultaID){
        return consultaService.deletar(consultaID);
    }
}
