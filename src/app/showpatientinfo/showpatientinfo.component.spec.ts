import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowpatientinfoComponent } from './showpatientinfo.component';

describe('ShowpatientinfoComponent', () => {
  let component: ShowpatientinfoComponent;
  let fixture: ComponentFixture<ShowpatientinfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowpatientinfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowpatientinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
