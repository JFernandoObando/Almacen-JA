import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { MenuComponent } from './Components/menu/menu.component';
import { ClienteComponent } from './Components/cliente/cliente.component';
import { ClienteIngresoComponent } from './Components/cliente-ingreso/cliente-ingreso.component';
import { ArticulosComponent } from './Components/articulos/articulos.component';

import { OrdenComponent } from './Components/orden/orden.component';

import { HttpClient, HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ClienteIngresoComponent,
    ArticulosComponent,
    MenuComponent,
    OrdenComponent,
    ClienteComponent,
  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
