import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarSignInComponent } from './navbar-sign-in.component';

describe('NavbarSignInComponent', () => {
  let component: NavbarSignInComponent;
  let fixture: ComponentFixture<NavbarSignInComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarSignInComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarSignInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
