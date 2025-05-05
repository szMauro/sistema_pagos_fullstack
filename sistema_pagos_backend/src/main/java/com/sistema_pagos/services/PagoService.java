package com.sistema_pagos.services;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sistema_pagos.entities.Estudiante;
import com.sistema_pagos.entities.Pago;
import com.sistema_pagos.enums.EstadoPago;
import com.sistema_pagos.enums.TipoPago;
import com.sistema_pagos.repository.EstudianteRepository;
import com.sistema_pagos.repository.PagoRepository;

@Service
@Transactional
public class PagoService {
    private final PagoRepository pagoRepository;
    private final EstudianteRepository estudianteRepository;

    PagoService(PagoRepository pagoRepository, EstudianteRepository estudianteRepository) {
        this.pagoRepository = pagoRepository;
        this.estudianteRepository = estudianteRepository;
    }

    public Pago savePago(MultipartFile file, double cantidad, TipoPago tipoPago, LocalDate fecha,
            String codigoEstudiante)
            throws IOException {

        Path folderPath = Paths.get(System.getProperty("user.home"), "enset-data", "pagos");

        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        String fileName = UUID.randomUUID().toString();

        Path filePath = Paths.get(System.getProperty("user.home"), "enset-data", "pagos", fileName + ".pdf");
        Files.copy(file.getInputStream(), filePath);

        Estudiante estudiante = estudianteRepository.findByCodigo(codigoEstudiante);
        Pago pago = Pago.builder()
                .tipoPago(tipoPago)
                .estadoPago(EstadoPago.CREADO)
                .fecha(fecha)
                .estudiante(estudiante)
                .cantidad(cantidad)
                .file(filePath.toUri().toString())
                .build();

        return pagoRepository.save(pago);
    }

    public byte[] getArchivoPorId(Long pagoId) throws IOException {
        Pago pago = pagoRepository.findById(pagoId).get();

        return Files.readAllBytes(Path.of(URI.create(pago.getFile())));
    }

    public Pago actualizarPagoPorEstado(EstadoPago estadoPago, Long id) {
        Pago pago = pagoRepository.findById(id).get();
        pago.setEstadoPago(estadoPago);
        return pagoRepository.save(pago);
    }
}
