import { Component, OnInit } from '@angular/core';
import { EstudiantesService } from '../../services/estudiantes.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent implements OnInit {
  pagosRealizados = 0;
  estudiantesRegistrados = 0;

  constructor(
    private http: HttpClient,
    private estudianteService: EstudiantesService
  ) {}

  ngOnInit(): void {
    this.getEstudiantesRegistrados();
    this.getPagosRealizados();
  }

  getEstudiantesRegistrados() {
    this.estudianteService.getAllEstudiantes().subscribe({
      next: (data) => {
        this.estudiantesRegistrados = data.length;
      },
      error: (err) => console.log(err),
    });
  }
  getPagosRealizados() {
    this.estudianteService.getAllPagos().subscribe({
      next: (data) => {
        const pagosValidados = data.filter(
          (pago) => pago.estadoPago == 'VALIDADO'
        );

        this.pagosRealizados = pagosValidados.length;
      },
      error: (err) => console.log(err),
    });
  }
}
