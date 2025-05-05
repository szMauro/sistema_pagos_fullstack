import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CargarPagosComponent } from './cargar-pagos.component';

describe('CargarPagosComponent', () => {
  let component: CargarPagosComponent;
  let fixture: ComponentFixture<CargarPagosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CargarPagosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CargarPagosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
