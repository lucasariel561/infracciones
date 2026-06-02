package com.example.infracciones.controllers;

import com.example.infracciones.entities.Conductor;
import com.example.infracciones.services.ConductorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conductores")
@RequiredArgsConstructor
public class ConductorController {

    private final ConductorService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaConductores", service.obtenerTodos());
        return "conductores";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("conductor", new Conductor());
        return "nuevo_conductor";
    }

    @PostMapping("/guardar")
    public String guardar(Conductor conductor) {
        service.guardarConductor(conductor);
        return "redirect:/panel/registros";
    }

}