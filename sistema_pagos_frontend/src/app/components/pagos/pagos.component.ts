import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Pago } from '../../models/estudiantes.model';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { HttpClient } from '@angular/common/http';
import { EstudiantesService } from '../../services/estudiantes.service';

@Component({
  selector: 'app-pagos',
  standalone: false,
  templateUrl: './pagos.component.html',
  styleUrl: './pagos.component.css',
})
export class PagosComponent implements OnInit {
  public pagos: any;
  public dataSource!: MatTableDataSource<Pago>;
  public displayedColumns = [
    'id',
    'fecha',
    'cantidad',
    'tipo',
    'estado',
    'nombre',
  ];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private http: HttpClient,
    private estudianteService: EstudiantesService
  ) {}

  ngOnInit(): void {
    this.estudianteService.getAllPagos().subscribe({
      next: (data) => {
        this.pagos = data;
        this.dataSource = new MatTableDataSource(this.pagos);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      error: (err) => console.log(err),
    });
  }
}
