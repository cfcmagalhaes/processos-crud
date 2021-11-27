import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessoDetailComponent } from './processo-detail.component';

describe('ProcessoDetailComponent', () => {
  let component: ProcessoDetailComponent;
  let fixture: ComponentFixture<ProcessoDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcessoDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
