package com.example.infracciones.controllers;

import com.example.infracciones.entities.TipoDeInfraccion;
import com.example.infracciones.services.TipoDeInfraccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tipos-infraccion")
@RequiredArgsConstructor
public class TipoDeInfraccionController {

    private final TipoDeInfraccionService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaTipos", service.obtenerTodos());
        return "tipos_infraccion";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("tipoInfraccion", new TipoDeInfraccion());
        return "nuevo_tipo_infraccion";
    }

    @PostMapping("/guardar")
    public String guardar(TipoDeInfraccion tipo) {
        service.guardarTipo(tipo);
        return "redirect:/tipos-infraccion";
    }
}