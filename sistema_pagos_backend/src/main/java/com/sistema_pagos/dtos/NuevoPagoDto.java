package com.sistema_pagos.dtos;

import java.time.LocalDate;

import com.sistema_pagos.enums.TipoPago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NuevoPagoDto {
    private double cantidad;
    private TipoPago tipoPago;
    private LocalDate fecha;
    private String codigoEstudiante;
}
