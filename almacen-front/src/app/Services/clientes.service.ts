import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../Models/Cliente';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private url = 'http://localhost:8080/cliente/';


  constructor(private httpClient : HttpClient) { }

  getCliente():Observable<any>{
  
    return this.httpClient.get(this.url)
  }

 
    crearCliente(cliente: Cliente):Observable<any> {
  
      return this.httpClient.post(`${this.url}`, cliente);
    }

    eliminarCliente(id: any):Observable<any>{
      return this.httpClient.delete(this.url+"delete/"+id)
    }

}


