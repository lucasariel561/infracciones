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

@Entity
@Table(name = "vehiculos_registrados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vehiculo extends Base {

    @Column(name = "color_vehiculo")
    String colorVehiculo;

    @Column(name = "patente_dominio")
    String patenteDominio;

    @Column(name = "anio_patentamiento")
    Integer anioPatentamiento;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    Marca marca;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    Modelo modelo;
}