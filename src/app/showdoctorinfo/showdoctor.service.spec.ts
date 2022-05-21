import { TestBed } from '@angular/core/testing';

import { ShowdoctorService } from './showdoctor.service';

describe('ShowdoctorService', () => {
  let service: ShowdoctorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShowdoctorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
