import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarburantComponent } from './carburant/carburant.component';
import { StationComponent } from './station/station.component';
import { HistocarbComponent } from './histocarb/histocarb.component';
const routes: Routes = [
  { path: 'carburant', component: CarburantComponent },
  { path: 'station', component: StationComponent },
  { path: 'histocarb', component: HistocarbComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
