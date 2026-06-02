package com.example.infracciones.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@MappedSuperclass
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Persona extends Base {

    @Column(name = "nombres_completos")
    String nombres;

    @Column(name = "apellidos_completos")
    String apellidos;

    @Column(name = "documento_identidad")
    String documentoIdentidad;
}