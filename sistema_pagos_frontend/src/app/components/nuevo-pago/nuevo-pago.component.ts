import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Event } from '@angular/router';
import { EstudiantesService } from '../../services/estudiantes.service';
import { TipoPago } from '../../models/estudiantes.model';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nuevo-pago',
  standalone: false,
  templateUrl: './nuevo-pago.component.html',
  styleUrl: './nuevo-pago.component.css',
})
export class NuevoPagoComponent implements OnInit {
  pagoFormGroup!: FormGroup;
  codigoEstudiante!: string;
  tiposPago: string[] = [];
  pdfFileUrl!: string;

  constructor(
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private estudianteService: EstudiantesService
  ) {}

  ngOnInit(): void {
    for (let el in TipoPago) {
      let value = TipoPago[el];
      if (typeof value == 'string') this.tiposPago.push(value);
    }

    this.codigoEstudiante =
      this.activatedRoute.snapshot.params['codigoEstudiante'];

    this.pagoFormGroup = this.formBuilder.group({
      fecha: this.formBuilder.control(''),
      cantidad: this.formBuilder.control(''),
      tipoPago: this.formBuilder.control(''),
      codigoEstudiante: this.formBuilder.control(this.codigoEstudiante),
      fileSource: this.formBuilder.control(''),
      fileName: this.formBuilder.control(''),
    });
  }

  selectFile(event: any) {
    if (event.target.files.length > 0) {
      let file = event.target.files[0];
      this.pagoFormGroup.patchValue({
        fileSource: file,
        fileName: file.name,
      });
      this.pdfFileUrl = window.URL.createObjectURL(file);
    }
  }

  guardarPago() {
    let date: Date = this.pagoFormGroup.get('fecha')?.value;
    if (!date) {
      Swal.fire('Error', 'La fecha es requerida', 'error');
      return;
    }
    let formattedDate =
      date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear();

    let formData = new FormData();
    formData.append('fecha', formattedDate);

    const tipoPago = this.pagoFormGroup.get('tipoPago')?.value;
    if (!tipoPago) {
      Swal.fire('Error', 'El tipo de pago es requerido', 'error');
      return;
    }
    formData.append('tipoPago', this.pagoFormGroup.value.tipoPago);

    formData.append('cantidad', this.pagoFormGroup.value.cantidad);
    formData.append(
      'codigoEstudiante',
      this.pagoFormGroup.value.codigoEstudiante
    );
    formData.append('file', this.pagoFormGroup.value.fileSource);

    this.estudianteService.guardarPago(formData).subscribe({
      next: (value) => {
        Swal.fire({
          title: 'Pago Guardado',
          text: 'El pago ha sido registrado con éxito',
          icon: 'success',
        });
      },
      error: (err) => {
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'Ha ocurrido un error al registrar el Pago',
        });
      },
    });
  }
}
