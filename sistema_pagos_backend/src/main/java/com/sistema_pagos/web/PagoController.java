package com.sistema_pagos.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sistema_pagos.entities.Estudiante;
import com.sistema_pagos.entities.Pago;
import com.sistema_pagos.enums.EstadoPago;
import com.sistema_pagos.enums.TipoPago;
import com.sistema_pagos.repository.EstudianteRepository;
import com.sistema_pagos.repository.PagoRepository;
import com.sistema_pagos.services.PagoService;

@RestController
public class PagoController {
    private final EstudianteRepository estudianteRepository;
    private final PagoRepository pagoRepository;
    private final PagoService pagoService;

    PagoController(EstudianteRepository estudianteRepository, PagoRepository pagoRepository, PagoService pagoService) {
        this.estudianteRepository = estudianteRepository;
        this.pagoRepository = pagoRepository;
        this.pagoService = pagoService;
    }

    @GetMapping("/estudiantes")
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @GetMapping("/estudiantes/{codigo}")
    public Estudiante listarEstudiantePorCodigo(@PathVariable String codigo) {
        return estudianteRepository.findByCodigo(codigo);
    }

    @GetMapping("/estudiantesPorPrograma")
    public List<Estudiante> listarEstudiantesPorPrograma(@RequestParam String programaId) {
        return estudianteRepository.findByProgramaId(programaId);
    }

    @GetMapping("/pagos")
    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }

    @GetMapping("/pagos/{id}")
    public Pago listarPagoPorId(@PathVariable Long id) {
        return pagoRepository.findById(id).get();
    }

    @GetMapping("/estudiantes/{codigo}/pagos")
    public List<Pago> listarPagosPorCodigoEstudiante(@PathVariable String codigo) {
        return pagoRepository.findByEstudianteCodigo(codigo);
    }

    @GetMapping("/pagosPorEstado")
    public List<Pago> listarPagosPorEstado(@RequestParam EstadoPago estadoPago) {
        return pagoRepository.findByEstadoPago(estadoPago);
    }

    @GetMapping("/pagos/porTipo")
    public List<Pago> listarPagosPorTipoPago(@RequestParam TipoPago tipoPago) {
        return pagoRepository.findByTipoPago(tipoPago);
    }

    @PutMapping("/pagos/{pagoId}/actualizarPago")
    public Pago actualizarEstadoDePago(@RequestParam EstadoPago estadoPago, @PathVariable Long pagoId) {
        return pagoService.actualizarPagoPorEstado(estadoPago, pagoId);
    }

    @PostMapping(path = "/pagos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Pago guardarPago(@RequestParam("file") MultipartFile file, double cantidad, TipoPago tipoPago,
            LocalDate fecha,
            String codigoEstudiante) throws IOException {
        return pagoService.savePago(file, cantidad, tipoPago, fecha, codigoEstudiante);
    }

    @GetMapping(value = "/pagoFile/{pagoId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] listarArchivoPorId(@PathVariable Long pagoId) throws IOException {
        return pagoService.getArchivoPorId(pagoId);
    }
}
