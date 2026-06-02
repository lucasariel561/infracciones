package com.example.infracciones.controllers;

import com.example.infracciones.entities.AutoridadConstatacion;
import com.example.infracciones.entities.Conductor;
import com.example.infracciones.entities.Vehiculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class RegistroController {

    @GetMapping("/registros")
    public String panelUnificado(Model model) {
        model.addAttribute("autoridad", new AutoridadConstatacion());
        model.addAttribute("conductor", new Conductor());
        model.addAttribute("vehiculo", new Vehiculo());
        return "panel_registros";
    }
}