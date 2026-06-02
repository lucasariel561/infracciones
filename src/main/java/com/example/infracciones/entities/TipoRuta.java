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

@Entity
@Table(name = "tipos_de_rutas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TipoRuta extends Base {

    @Column(name = "descripcion_tipo")
    String descripcionTipo;

    @Column(name = "clasificacion_ruta")
    String clasificacionRuta;

    @Column(name = "es_internacional")
    Boolean esInternacional;

    @Column(name = "es_nacional")
    Boolean esNacional;

    @Column(name = "es_provincial")
    Boolean esProvincial;
}