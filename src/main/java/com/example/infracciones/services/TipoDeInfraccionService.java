package com.example.infracciones.services;

import com.example.infracciones.entities.TipoDeInfraccion;
import com.example.infracciones.repositories.TipoDeInfraccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoDeInfraccionService {

    private final TipoDeInfraccionRepository repository;

    public List<TipoDeInfraccion> obtenerTodos() {
        return repository.findAll();
    }

    public void guardarTipo(TipoDeInfraccion tipo) {
        repository.save(tipo);
    }
}