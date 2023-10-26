import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Articulo } from '../Models/Articulo';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ArticuloService {
  private url = 'http://localhost:8080/articulo/';


  constructor(private httpClient : HttpClient) { }

  getArticulo():Observable<any>{
    console.log("sll")
    return this.httpClient.get(this.url)
  }

  

 
    crearArticulo(articulo: Articulo):Observable<any> {
    console.log("sdkk")
      return this.httpClient.post(`${this.url}`, articulo);
    }

}

