package com.sistema_pagos.entities;

import java.time.LocalDate;

import com.sistema_pagos.enums.EstadoPago;
import com.sistema_pagos.enums.TipoPago;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private double cantidad;
    private TipoPago tipoPago;
    private EstadoPago estadoPago;
    private String file;
    @ManyToOne
    private Estudiante estudiante;
}
