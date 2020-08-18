import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OffreTanitComponent } from './offre-tanit.component';

describe('OffreTanitComponent', () => {
  let component: OffreTanitComponent;
  let fixture: ComponentFixture<OffreTanitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OffreTanitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OffreTanitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
