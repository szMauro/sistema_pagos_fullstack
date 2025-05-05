package com.sistema_pagos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema_pagos.entities.Pago;
import com.sistema_pagos.enums.EstadoPago;
import com.sistema_pagos.enums.TipoPago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByEstudianteCodigo(String codigo);

    List<Pago> findByEstadoPago(EstadoPago estado);

    List<Pago> findByTipoPago(TipoPago tipoPago);
}
