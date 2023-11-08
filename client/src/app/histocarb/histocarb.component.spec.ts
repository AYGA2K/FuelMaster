import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistocarbComponent } from './histocarb.component';

describe('HistocarbComponent', () => {
  let component: HistocarbComponent;
  let fixture: ComponentFixture<HistocarbComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HistocarbComponent]
    });
    fixture = TestBed.createComponent(HistocarbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
