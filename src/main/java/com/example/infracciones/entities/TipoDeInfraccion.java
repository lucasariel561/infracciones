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
@Table(name = "catalogo_tipos_infraccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TipoDeInfraccion extends Base {

    @Column(name = "detalle_infraccion")
    String detalleInfraccion;

    @Column(name = "nivel_gravedad")
    String nivelGravedad;

    @Column(name = "monto_base")
    Double montoBase;

    @Column(name = "descuento_aplicable")
    Double descuentoAplicable;
}