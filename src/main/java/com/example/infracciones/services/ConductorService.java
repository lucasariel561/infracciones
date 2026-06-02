package com.example.infracciones.services;

import com.example.infracciones.entities.Conductor;
import com.example.infracciones.repositories.ConductorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConductorService {

    private final ConductorRepository repository;

    public List<Conductor> obtenerTodos() {
        return repository.findAll();
    }

    public void guardarConductor(Conductor conductor) {
        repository.save(conductor);
    }
}

