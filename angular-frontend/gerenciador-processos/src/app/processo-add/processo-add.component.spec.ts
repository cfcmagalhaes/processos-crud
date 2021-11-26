import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessoAddComponent } from './processo-add.component';

describe('ProcessoAddComponent', () => {
  let component: ProcessoAddComponent;
  let fixture: ComponentFixture<ProcessoAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcessoAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessoAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
