import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StationComponent } from './station/station.component';
import { CarburantComponent } from './carburant/carburant.component';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [AppComponent, StationComponent, CarburantComponent],
  imports: [BrowserModule, HttpClientModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
