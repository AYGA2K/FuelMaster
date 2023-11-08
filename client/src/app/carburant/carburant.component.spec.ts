import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface Carburant {
  id?: number;
  name: string;
  description: string;
}

@Component({
  selector: 'app-carburant',
  templateUrl: './carburant.component.html',
  styleUrls: ['./carburant.component.scss'],
})
export class CarburantComponent {
  constructor(private http: HttpClient) {}

  carburants: Carburant[] = [];
  carburant: Carburant = {
    name: '',
    description: '',
  };
  showForm = false;
  editForm = false;
  newCarburant: Carburant = {
    name: '',
    description: '',
  };
  api: string = 'http://localhost:8080/';

  toggleForm() {
    this.showForm = !this.showForm;
  }

  ngOnInit() {
    this.http.get<Carburant[]>(this.api + 'carburants').subscribe((data) => {
      this.carburants = data;
    });
  }

  addCarburant() {
    this.http
      .post(this.api + 'carburants', this.newCarburant, {
        responseType: 'text',
      })
      .subscribe((data) => {
        this.ngOnInit();
        this.showForm = false;
      });
  }

  showEditForm(carburant: Carburant) {
    this.editForm = true;
    this.carburant = carburant;
  }

  editCarburant() {
    this.http
      .put(this.api + 'carburants/' + this.carburant.id, this.carburant, {
        responseType: 'text',
      })
      .subscribe((data) => {
        this.ngOnInit();
        this.editForm = false;
      });
  }

  deleteCarburant(carburant: Carburant) {
    this.http
      .delete(this.api + 'carburants/' + carburant.id, { responseType: 'text' })
      .subscribe((data) => {
        this.ngOnInit();
      });
  }
}
