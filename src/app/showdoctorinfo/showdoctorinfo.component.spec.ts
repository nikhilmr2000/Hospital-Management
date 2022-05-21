import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowdoctorinfoComponent } from './showdoctorinfo.component';

describe('ShowdoctorinfoComponent', () => {
  let component: ShowdoctorinfoComponent;
  let fixture: ComponentFixture<ShowdoctorinfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowdoctorinfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowdoctorinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
