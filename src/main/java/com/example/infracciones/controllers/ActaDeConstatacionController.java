package com.example.infracciones.controllers;

import com.example.infracciones.entities.ActaDeConstatacion;
import com.example.infracciones.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actas")
@RequiredArgsConstructor
public class ActaDeConstatacionController {

    private final ActaDeConstatacionService actaService;
    private final ConductorService conductorService;
    private final VehiculoService vehiculoService;
    private final AutoridadConstatacionService autoridadService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaActas", actaService.obtenerTodas());
        return "index";
    }

    @GetMapping("/nueva")
    public String formulario(Model model) {
        model.addAttribute("acta", new ActaDeConstatacion());
        model.addAttribute("conductores", conductorService.obtenerTodos());
        model.addAttribute("vehiculos", vehiculoService.obtenerTodos());
        model.addAttribute("autoridades", autoridadService.obtenerTodas());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(ActaDeConstatacion acta) {
        actaService.guardarActa(acta);
        return "redirect:/actas";
    }
}