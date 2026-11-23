package com.hibernate.ferreteria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "articulos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_articulo", nullable = false, length = 50)
    private String nombreArticulo;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "existencia", nullable = false)
    private Integer existencia;
}
