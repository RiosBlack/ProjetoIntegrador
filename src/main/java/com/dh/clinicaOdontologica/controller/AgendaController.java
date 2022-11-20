package com.dh.clinicaOdontologica.controller;


import com.dh.clinicaOdontologica.model.Agenda;
import com.dh.clinicaOdontologica.service.AgendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/agenda")
public class AgendaController {
    AgendaService agendaService = new AgendaService();

    @GetMapping()
    public List<Agenda> buscar(){
        return agendaService.buscar();
    }

    @PostMapping()
    public Agenda salvar(@RequestBody Agenda agenda){
        return agendaService.salvar(agenda);
    }
}
