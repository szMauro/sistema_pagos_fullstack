package com.sistema_pagos;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sistema_pagos.entities.Estudiante;
import com.sistema_pagos.entities.Pago;
import com.sistema_pagos.enums.EstadoPago;
import com.sistema_pagos.enums.TipoPago;
import com.sistema_pagos.repository.EstudianteRepository;
import com.sistema_pagos.repository.PagoRepository;

@SpringBootApplication
public class SistemaPagosBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPagosBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(EstudianteRepository estudianteRepository, PagoRepository pagoRepository) {
		return args -> {
			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Christian")
					.apellido("Ramirez")
					.codigo("1234")
					.programaId("A1")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Brian")
					.apellido("Ramirez")
					.codigo("12354")
					.programaId("A1")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Maria")
					.apellido("Portillo")
					.codigo("1256634")
					.programaId("A2")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Matias")
					.apellido("Galarza")
					.codigo("12349030")
					.programaId("B1")
					.build());

			TipoPago tiposPago[] = TipoPago.values();
			Random random = new Random();

			estudianteRepository.findAll().forEach(estudiante -> {
				for (int i = 0; i < 10; i++) {
					int index = random.nextInt(tiposPago.length);
					Pago pago = Pago.builder()
							.cantidad(1000 + (int) (Math.random() * 20000))
							.tipoPago(tiposPago[index])
							.estadoPago(EstadoPago.values()[random.nextInt(EstadoPago.values().length)])
							.fecha(LocalDate.now())
							.estudiante(estudiante)
							.build();
					pagoRepository.save(pago);
				}
			});
		};
	}
}
