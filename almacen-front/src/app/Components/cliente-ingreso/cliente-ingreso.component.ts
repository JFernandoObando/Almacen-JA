import { Component,OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Cliente } from 'src/app/Models/Cliente';
import { ClienteService } from 'src/app/Services/clientes.service';

@Component({
  selector: 'app-cliente-ingreso',
  templateUrl: './cliente-ingreso.component.html',
  styleUrls: ['./cliente-ingreso.component.css']
})
export class ClienteIngresoComponent implements OnInit {
  clienteForm: FormGroup;
  listCliente: Cliente[] = [];
  public clienteService :ClienteService

  constructor(private fb: FormBuilder){
    this.clienteForm= this.fb.group({
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
    });
  }

  ngOnInit():void{
    /*this.clienteService.getCliente().subscribe(resp=>{
      this.listCliente=resp;
      console.log(resp)
    },
    error=>{
      console.error(error)
    }
    )*/
    this.listCliente=[{
     "nombre":"Juan",
     "apellido":"Perez"
    },
    {"nombre":"Erick",
     "apellido":"Perez"}
   ]
     console.log("Aaks")
   }

  agregarCliente(){
    console.log("aaa")
    if (this.clienteForm.valid) {
      const formulario: Cliente = {
      nombre: this.clienteForm.get('nombre')?.value || '',
      apellido: this.clienteForm.get('apellido')?.value || '',
    };
    const cliente = this.clienteForm.value;
    console.log(formulario);

/*
    this._ClienteIngresoService.crearCriterio(formulario).subscribe(
      (response) => {
        this.toastr.success('Criterio registrado correctamente!', 'Éxito!');
        this.criteriosForm.reset();
        this.valorCombo = false;
        this.criteriosForm.get('nombre')?.setValue('');
      },
      (error) => {
        this.toastr.error('Error al crear el criterio.', 'Error');
        this.clienteForm.reset();
        this.valorCombo = false;
        this.clienteForm.get('apellido')?.setValue('');
        console.error('Error:', error);
      }
    );*/

  }
  }
}
