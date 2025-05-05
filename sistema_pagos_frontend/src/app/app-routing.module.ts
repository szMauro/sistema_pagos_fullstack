import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { AdminTemplateComponent } from './components/admin-template/admin-template.component';
import { AuthGuard } from './guards/auth.guard';
import { HomeComponent } from './components/home/home.component';
import { CargarEstudiantesComponent } from './components/cargar-estudiantes/cargar-estudiantes.component';
import { AuthorizationGuard } from './guards/authorization.guard';
import { CargarPagosComponent } from './components/cargar-pagos/cargar-pagos.component';
import { EstudiantesComponent } from './components/estudiantes/estudiantes.component';
import { PagosComponent } from './components/pagos/pagos.component';
import { EstudianteDetallesComponent } from './components/estudiante-detalles/estudiante-detalles.component';
import { NuevoPagoComponent } from './components/nuevo-pago/nuevo-pago.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  {
    path: 'admin',
    component: AdminTemplateComponent,
    canActivate: [AuthGuard],
    children: [
      { path: 'home', component: HomeComponent },
      {
        path: 'cargarEstudiantes',
        component: CargarEstudiantesComponent,
        canActivate: [AuthorizationGuard],
        data: { roles: ['ADMIN'] },
      },
      {
        path: 'cargarPagos',
        component: CargarPagosComponent,
        canActivate: [AuthorizationGuard],
        data: { roles: ['ADMIN'] },
      },
      { path: 'estudiantes', component: EstudiantesComponent },
      { path: 'pagos', component: PagosComponent },
      {
        path: 'estudiante-detalles/:codigo',
        component: EstudianteDetallesComponent,
      },
      { path: 'nuevo-pago/:codigoEstudiante', component: NuevoPagoComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
