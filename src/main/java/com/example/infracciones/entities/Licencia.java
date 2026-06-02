package com.example.infracciones.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Entity
@Table(name = "licencias_conducir")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Licencia extends Base {

    @Column(name = "fecha_vencimiento")
    LocalDate fechaVencimiento;

    @Column(name = "puntos_iniciales")
    Integer puntosIniciales;
}