import { Component, OnInit } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { ArticuloService } from 'src/app/Services/articulo.service';
import { FormGroup, FormBuilder,Validators } from '@angular/forms';
import { Articulo } from 'src/app/Models/Articulo';

@Component({
  selector: 'app-articulos',
  templateUrl: './articulos.component.html',
  styleUrls: ['./articulos.component.css']
})
export class ArticulosComponent  implements OnInit {
  articuloForm: FormGroup;
  listArticulo: Articulo[] = [];

  constructor(private fb: FormBuilder,private articuloServicio:ArticuloService){
    this.articuloForm= this.fb.group({
      nombre: ['', Validators.required],
      precio_u: ['', Validators.required],
    });
  }

  
ngOnInit():void{
 this.obtenerArticulo();
 console.log("ENTRA")
  

 }

 obtenerArticulo(){
  
  this.articuloServicio.getArticulo().pipe(

    tap(data => {
      console.log(data)
      this.listArticulo = data;
    }),
    catchError(error => {
      console.log(error);
      throw error;
    })
  ).subscribe();

 }

  agregarArticulo(){
    if (this.articuloForm.valid) {
      const formulario: Articulo = {
      nombre: this.articuloForm.get('nombre')?.value || '',
      precio_u: this.articuloForm.get('precio_u')?.value || '',
    };
    const articulo = this.articuloForm.value;
    console.log(formulario);


    this.articuloServicio.crearArticulo(formulario).subscribe(
      (response) => {
  
        this.articuloForm.reset();
        this.articuloForm.get('nombre')?.setValue('');
        this.obtenerArticulo();
      },
      (error) => {
       
        this.articuloForm.reset();
        this.articuloForm.get('precio_u')?.setValue('');
        console.error('Error:', error);
      }
    );

  }
  }

}
