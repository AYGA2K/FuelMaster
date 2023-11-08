import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface Histocarb {
  id?: number;
  price: number;
  date: Date;
  station: {
    id: number;
    name?: string;
  };
  carburant: {
    id: number;
    name?: string;
  };
}

@Component({
  selector: 'app-histocarb',
  templateUrl: './histocarb.component.html',
  styleUrls: ['./histocarb.component.scss'],
})
export class HistocarbComponent {
  constructor(private http: HttpClient) {}
  histocarbs: Histocarb[] = [];
  histocarb: Histocarb = {
    price: 0,
    date: new Date(),
    station: {
      id: 0,
      name: '',
    },
    carburant: {
      id: 0,
      name: '',
    },
  };
  showForm = false;
  editForm = false;
  newHistocarb: Histocarb = {
    price: 0,
    date: new Date(),
    station: {
      id: 0,
      name: '',
    },
    carburant: {
      id: 0,
      name: '',
    },
  };
  api: string = 'http://localhost:8080/';

  toggleForm() {
    this.showForm = !this.showForm;
  }

  ngOnInit() {
    this.http.get<Histocarb[]>(this.api + 'histocarbs').subscribe((data) => {
      this.histocarbs = data;
    });
  }

  addHistocarb() {
    this.http
      .post(this.api + 'histocarbs', this.newHistocarb, {
        responseType: 'text',
      })
      .subscribe((data) => {
        this.ngOnInit();
        this.showForm = false;
      });
  }

  showEditForm(histocarb: Histocarb) {
    this.editForm = true;
    this.histocarb = histocarb;
  }

  editHistocarb() {
    this.http
      .put(this.api + 'histocarbs/' + this.histocarb.id, this.histocarb, {
        responseType: 'text',
      })
      .subscribe((data) => {
        this.ngOnInit();
        this.editForm = false;
      });
  }

  deleteHistocarb(histocarb: Histocarb) {
    this.http
      .delete(this.api + 'histocarbs/' + histocarb.id, { responseType: 'text' })
      .subscribe((data) => {
        this.ngOnInit();
      });
  }
}
