package com.example.infracciones.services;

import com.example.infracciones.entities.ActaDeConstatacion;
import com.example.infracciones.repositories.ActaDeConstatacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActaDeConstatacionService {

    private final ActaDeConstatacionRepository repository;


    public List<ActaDeConstatacion> obtenerTodas() {
        return repository.findAll();
    }

    public void guardarActa(ActaDeConstatacion acta) {
        repository.save(acta);
    }
}