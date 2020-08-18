import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteCandidatComponent } from './compte-candidat.component';

describe('CompteCandidatComponent', () => {
  let component: CompteCandidatComponent;
  let fixture: ComponentFixture<CompteCandidatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompteCandidatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompteCandidatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
