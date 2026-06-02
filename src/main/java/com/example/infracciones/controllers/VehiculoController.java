package com.example.infracciones.controllers;

import com.example.infracciones.entities.Vehiculo;
import com.example.infracciones.services.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaVehiculos", service.obtenerTodos());
        return "vehiculos";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        return "nuevo_vehiculo";
    }

    @PostMapping("/guardar")
    public String guardar(Vehiculo vehiculo) {
        service.guardarVehiculo(vehiculo);
        return "redirect:/panel/registros";
    }
}