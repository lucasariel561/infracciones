package com.example.infracciones.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "actas_constatacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActaDeConstatacion extends Base {

    @Column(name = "fecha_emision")
    LocalDate fechaEmision;

    @Column(name = "hora_emision")
    LocalTime horaEmision;

    @Column(name = "fecha_vencimiento_pago")
    LocalDate fechaVencimientoPago;

    @Column(name = "ubicacion_hecho")
    String ubicacionHecho;

    @Column(name = "notas_adicionales", length = 500)
    String notasAdicionales;


    @ManyToOne
    @JoinColumn(name = "conductor_id")
    Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "autoridad_id")
    AutoridadConstatacion autoridad;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    Ruta ruta;
}