package com.dh.clinicaOdontologica.controller;


import com.dh.clinicaOdontologica.model.Agenda;
import com.dh.clinicaOdontologica.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/agenda")
@Controller
public class AgendaController {
    @Autowired
    AgendaService agendaService; //= new AgendaService();

    @GetMapping()
    public List<Agenda> buscar(){
        return agendaService.buscar();
    }

    @PostMapping()
    public Agenda salvar(@RequestBody Agenda agenda){
        return agendaService.salvar(agenda);
    }
}
