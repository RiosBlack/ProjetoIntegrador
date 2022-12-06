package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.entity.Consulta;
import com.dh.clinicaOdontologica.entity.dto.ConsultaDTO;
import com.dh.clinicaOdontologica.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/consulta")
@Controller
public class ConsultaController {
    @Autowired
    ConsultaService consultaService; //= new ConsultaService();

    @GetMapping()
    public List<ConsultaDTO> buscar(){
        return consultaService.buscar();
    }

    @PostMapping()
    public ResponseEntity salvar(@RequestBody @Valid ConsultaDTO consultaDTO){
        return consultaService.salvar(consultaDTO);
    }
    
    /*@DeleteMapping()
    public deletar (@RequestBody @Valid ConsultaDTO consultaDTO){
        return consultaService.deletar(consultaDTO);
    }*/
}
