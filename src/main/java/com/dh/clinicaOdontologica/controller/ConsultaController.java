package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.model.Consulta;
import com.dh.clinicaOdontologica.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
@Controller
public class ConsultaController {
    @Autowired
    ConsultaService consultaService; //= new ConsultaService();

    @GetMapping()
    public List<Consulta> buscar(){
        return consultaService.buscar();
    }

    @PostMapping()
    public Consulta salvar(@RequestBody Consulta consulta){
        return consultaService.salvar(consulta);
    }
}
