import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessoUpdateComponent } from './processo-update.component';

describe('ProcessoUpdateComponent', () => {
  let component: ProcessoUpdateComponent;
  let fixture: ComponentFixture<ProcessoUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcessoUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessoUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
