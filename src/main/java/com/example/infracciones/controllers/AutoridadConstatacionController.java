package com.example.infracciones.controllers;

import com.example.infracciones.entities.AutoridadConstatacion;
import com.example.infracciones.services.AutoridadConstatacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autoridades")
@RequiredArgsConstructor
public class AutoridadConstatacionController {

    private final AutoridadConstatacionService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaAutoridades", service.obtenerTodas());
        return "autoridades";
    }

    @GetMapping("/nueva")
    public String formulario(Model model) {
        model.addAttribute("autoridad", new AutoridadConstatacion());
        return "nueva_autoridad";
    }

    @PostMapping("/guardar")
    public String guardar(AutoridadConstatacion autoridad) {
        service.guardarAutoridad(autoridad);
        return "redirect:/panel/registros";
    }
    }
