package com.sistema_pagos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema_pagos.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
    Estudiante findByCodigo(String codigo);

    List<Estudiante> findByProgramaId(String programaId);
}
