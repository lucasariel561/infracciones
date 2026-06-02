package com.example.infracciones.services;

import com.example.infracciones.entities.AutoridadConstatacion;
import com.example.infracciones.repositories.AutoridadConstatacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoridadConstatacionService {

    private final AutoridadConstatacionRepository repository;

    public List<AutoridadConstatacion> obtenerTodas() {
        return repository.findAll();
    }

    public void guardarAutoridad(AutoridadConstatacion autoridad) {
        repository.save(autoridad);
    }
}