import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Estudiante, Pago } from '../models/estudiantes.model';

@Injectable({
  providedIn: 'root',
})
export class EstudiantesService {
  constructor(private http: HttpClient) {}

  public getAllPagos(): Observable<Array<Pago>> {
    return this.http.get<Array<Pago>>(`${environment.backendHost}/pagos`);
  }

  public getAllEstudiantes(): Observable<Array<Estudiante>> {
    return this.http.get<Array<Estudiante>>(
      `${environment.backendHost}/estudiantes`
    );
  }

  public getPagosDeEstudiante(codigo: string): Observable<Array<Pago>> {
    return this.http.get<Array<Pago>>(
      `${environment.backendHost}/estudiantes/${codigo}/pagos`
    );
  }

  public guardarPago(formData: any): Observable<Pago> {
    return this.http.post<Pago>(`${environment.backendHost}/pagos`, formData);
  }
}
