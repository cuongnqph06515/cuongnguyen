import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CeEmployeeComponent } from './ce-employee.component';

describe('CeEmployeeComponent', () => {
  let component: CeEmployeeComponent;
  let fixture: ComponentFixture<CeEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CeEmployeeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CeEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
