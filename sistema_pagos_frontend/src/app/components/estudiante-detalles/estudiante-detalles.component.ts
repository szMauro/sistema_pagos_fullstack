import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { Pago } from '../../models/estudiantes.model';
import { EstudiantesService } from '../../services/estudiantes.service';

@Component({
  selector: 'app-estudiante-detalles',
  standalone: false,
  templateUrl: './estudiante-detalles.component.html',
  styleUrl: './estudiante-detalles.component.css',
})
export class EstudianteDetallesComponent implements OnInit {
  estudianteCodigo!: string;
  pagosEstudiante!: Array<Pago>;
  pagosDataSource!: MatTableDataSource<Pago>;

  public displayedColumns = [
    'id',
    'fecha',
    'cantidad',
    'tipo',
    'estado',
    'nombre',
  ];

  constructor(
    private activatedRoute: ActivatedRoute,
    private estudiantesService: EstudiantesService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.estudianteCodigo = this.activatedRoute.snapshot.params['codigo'];
    this.estudiantesService
      .getPagosDeEstudiante(this.estudianteCodigo)
      .subscribe({
        next: (value) => {
          this.pagosEstudiante = value;
          this.pagosDataSource = new MatTableDataSource<Pago>(
            this.pagosEstudiante
          );
        },
        error: (err) => console.log(err),
      });
  }

  agregarPago() {
    this.router.navigateByUrl(`/admin/nuevo-pago/${this.estudianteCodigo}`);
  }
}
