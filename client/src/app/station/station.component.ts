import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
interface Station {
  id?: number;
  name: string;
  city: string;
  address: string;
}
@Component({
  selector: 'app-station',
  templateUrl: './station.component.html',
  styleUrls: ['./station.component.scss'],
})
export class StationComponent {
  constructor(private http: HttpClient) {}
  stations: Station[] = [];
  station: Station = {
    name: '',
    city: '',
    address: '',
  };
  showForm = false;
  editForm = false;
  newStation: Station = {
    name: '',
    city: '',
    address: '',
  };
  api: string = 'http://localhost:8080/';
  toggleForm() {
    this.showForm = !this.showForm;
  }

  ngOnInit() {
    this.http.get<Station[]>(this.api + 'stations').subscribe((data) => {
      this.stations = data;
    });
  }
  addStation() {
    this.http
      .post(this.api + 'stations', this.newStation, { responseType: 'text' })
      .subscribe((data) => {
        this.ngOnInit();
        this.showForm = false;
      });
  }
  showEditForm(station: Station) {
    this.editForm = true;
    this.station = station;
  }
  editStation() {
    this.http
      .put(this.api + 'stations/' + this.station.id, this.station, {
        responseType: 'text',
      })
      .subscribe((data) => {
        this.ngOnInit();
        this.editForm = false;
      });
  }

  deleteStation(station: Station) {
    this.http
      .delete(this.api + 'stations/' + station.id, { responseType: 'text' })
      .subscribe((data) => {
        this.ngOnInit();
      });
  }
}
