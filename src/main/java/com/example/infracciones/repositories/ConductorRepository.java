package com.example.infracciones.repositories;
import com.example.infracciones.entities.Conductor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends BaseRepository<Conductor, Long> { }