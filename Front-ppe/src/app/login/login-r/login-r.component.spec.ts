import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginRComponent } from './login-r.component';

describe('LoginRComponent', () => {
  let component: LoginRComponent;
  let fixture: ComponentFixture<LoginRComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginRComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginRComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
