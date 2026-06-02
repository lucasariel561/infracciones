package com.example.infracciones.repositories;
import com.example.infracciones.entities.Vehiculo;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends BaseRepository<Vehiculo, Long> { }