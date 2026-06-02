package com.example.infracciones.services;

import com.example.infracciones.entities.Vehiculo;
import com.example.infracciones.repositories.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository repository;

    public List<Vehiculo> obtenerTodos() {
        return repository.findAll();
    }

    public void guardarVehiculo(Vehiculo vehiculo) {
        repository.save(vehiculo);
    }
}