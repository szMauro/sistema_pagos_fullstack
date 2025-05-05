package com.sistema_pagos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Estudiante {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    @Column(unique = true)
    private String codigo;
    private String programaId;
}
