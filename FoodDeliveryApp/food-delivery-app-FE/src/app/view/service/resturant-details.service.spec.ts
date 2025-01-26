import { TestBed } from '@angular/core/testing';

import { ResturantDetailsService } from './resturant-details.service';

describe('ResturantDetailsService', () => {
  let service: ResturantDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResturantDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
