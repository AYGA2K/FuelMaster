import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
interface Station {
  id: number;
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
  api: string = 'http://localhost:8080/';
  ngOnInit() {
    this.http.get<Station[]>(this.api + 'stations').subscribe((data) => {
      console.log(data);
      this.stations = data;
    });
  }
  editStation(station: any) {
    // Implement the edit logic here
  }

  deleteStation(station: any) {
    // Implement the delete logic here
  }
}
