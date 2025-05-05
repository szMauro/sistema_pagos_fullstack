export interface Estudiante {
  id: string;
  codigo: string;
  nombre: string;
  apellido: string;
  programaId: string;
  foto: string;
}

export interface Pago {
  id: number;
  fecha: string;
  cantidad: number;
  tipo: string;
  estadoPago: string;
  file: string;
  estudiante: Estudiante;
}

export enum TipoPago {
  EFECTIVO = 0,
  CHEQUE = 1,
  TRANSFERENCIA = 2,
  DEPOSITO = 3,
}

export enum EstadoPago {
  CREADO = 0,
  VALIDADO = 1,
  RECHAZADO = 2,
}
