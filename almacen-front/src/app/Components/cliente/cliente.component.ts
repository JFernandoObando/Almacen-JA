import { Component, OnInit } from '@angular/core';
import { ClienteService } from 'src/app/Services/clientes.service';
import { catchError, tap } from 'rxjs/operators';
import { Cliente } from 'src/app/Models/Cliente';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {
  clientesForm: FormGroup;
  listCliente: Cliente[] = [];

  constructor(private fb: FormBuilder,private clienteServicio: ClienteService)
   {
    this.clientesForm= this.fb.group({
      id:['',],
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
    });
  }

ngOnInit():void{

this.obtenerCliente();
}

private obtenerCliente(){
  console.log("ENTRA")
  

  this.clienteServicio.getCliente().pipe(
    tap(data => {
      this.listCliente = data;
    }),
    catchError(error => {
      console.log(error);
      throw error;
    })
  ).subscribe();
}



eliminarElemento(nombreCliente: any){
  console.log(nombreCliente)

  this.clienteServicio.eliminarCliente(nombreCliente).subscribe(
    (response) => {

    //  this.clientesForm.reset();
   //   this.clientesForm.get('nombre')?.setValue('');
      this.obtenerCliente();
    },
    (error) => {
     
    //  this.clientesForm.reset();
     // this.clientesForm.get('apellido')?.setValue('');
      console.error('Error:', error);
    }
  );
}


editarElemento(cliente: any){
this.clientesForm.setValue({
  id:cliente.id,
  nombre:cliente.nombre,
  apellido:cliente.apellido
})
}

agregarCliente(){
  console.log("aaa")
  if (this.clientesForm.valid) {
    const formulario: Cliente = {
      id: this.clientesForm.get('id')?.value || '',
    nombre: this.clientesForm.get('nombre')?.value || '',
    apellido: this.clientesForm.get('apellido')?.value || '',
  };
  const cliente = this.clientesForm.value;
  console.log(formulario);
 

  this.clienteServicio.crearCliente(formulario).subscribe(
    (response) => {

      this.clientesForm.reset();
      this.listCliente=this.listCliente.filter(listCliente=>response.id!==listCliente.id);
      this.clientesForm.get('nombre')?.setValue('');
      this.obtenerCliente();
    },
    (error) => {
     
      this.clientesForm.reset();
      this.clientesForm.get('apellido')?.setValue('');
      console.error('Error:', error);
    }
  );

}
}

}
