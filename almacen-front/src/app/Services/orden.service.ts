import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Orden } from '../Models/Orden';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class OrdenService {
  private url = 'http://localhost:8080/orden/';


  constructor(private httpClient : HttpClient) { }

  getOrden():Observable<any>{
    console.log("sll")
    return this.httpClient.get(this.url)
  }
  
  getDetalle():Observable<any>{
    console.log("sll")
    return this.httpClient.get(`${this.url}detalles`)
  }

 
    crearOrden(orden: Orden):Observable<any> {
    console.log("sdkk")
      return this.httpClient.post(`${this.url}`, orden);
    }

  

}

