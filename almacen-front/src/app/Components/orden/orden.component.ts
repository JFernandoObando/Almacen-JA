import { Component,OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Articulo } from 'src/app/Models/Articulo';
import { catchError, tap } from 'rxjs/operators';
import { Orden } from 'src/app/Models/Orden';
import { ArticuloService } from 'src/app/Services/articulo.service';
import { Cliente } from 'src/app/Models/Cliente';
import { ClienteService } from 'src/app/Services/clientes.service';
import { OrdenService } from 'src/app/Services/orden.service';

@Component({
  selector: 'app-orden',
  templateUrl: './orden.component.html',
  styleUrls: ['./orden.component.css']
})
export class OrdenComponent implements OnInit {
  ordenForm: FormGroup;
   listOrden: Orden[] = [];
   listDetalle: any[] = [];
   listArticulo:Articulo[]=[]
   listCliente:Cliente[]=[]
   ultimoId:any;
   clientess:any;
   articuloo:any;
   selectedCliente: Cliente | null = null;
   selectedArticulo: Articulo | null = null;
  constructor(private fb: FormBuilder,public ordenService: OrdenService,private articuloServicio: ArticuloService,private clienteServicio: ClienteService){
    this.ordenForm= this.fb.group({

      fecha: ['', Validators.required],
      cliente: this.selectedCliente,
      articulo: this.selectedArticulo,
    });
  }

  getElementosArticulo() {
    this.articuloServicio.getArticulo().pipe(
      tap(data => {
        this.listArticulo = data;
      }),
      catchError(error => {
        console.log(error);
        throw error;
      })
    ).subscribe();
  }

  getElementosCliente() {
  
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

  getOrden() {
    this.ordenService.getOrden().pipe(
      tap(data => {
        this.listOrden = data;
      }),
      catchError(error => {
        console.log(error);
        throw error;
      })
    ).subscribe();
  }

  getDetalle() {
 
    this.ordenService.getDetalle().pipe(
      tap(data => {
 
        console.log(data)
        this.listDetalle= data;
        console.log(this.listDetalle)
      }),
      catchError(error => {
        console.log(error);
        throw error;
      })
    ).subscribe();
  }


  ngOnInit():void{
    this.ordenForm=this.fb.group({
    id :['',Validators.required],
		fecha :['',Validators.required],
		articulo :['',Validators.required],
		cliente :['',Validators.required],
    })

    this.articuloServicio.getArticulo().subscribe(resp=>{
      this.articuloo=resp;
      console.log(resp)
    },
    error=>{
      console.error(error)
    })

    this.clienteServicio.getCliente().subscribe(resp=>{
      this.clientess=resp;
      console.log(resp)
    },
    error=>{
      console.error(error)
    }
    )

      this.getOrden();
        
      this.getDetalle();
    
   }
   




  agregarOrden ():void{

    const idsOrden = this.listOrden.map(orden => orden.id).filter(id => id !== null && id !== undefined);
    this.ultimoId = idsOrden[idsOrden.length - 1];
    console.log(this.ultimoId)
    
  console.log(this.ultimoId)
  const numeros = parseInt(this.ultimoId.match(/\d+$/)[0], 10);
  const numerosMasUno = numeros + 1; // Sumar 1
  const nuevoUltimoId = this.ultimoId.replace(/\d+$/, numerosMasUno.toString().padStart(this.ultimoId.length - 3, "0"));
  this.ordenForm.patchValue({ id: nuevoUltimoId });
    this.ordenService.crearOrden(this.ordenForm.value).subscribe(
      resp=>{
        this.getOrden();
        this.getDetalle();
        this.ordenForm.reset();
      },
      error=>{
        console.error(error)
      }
    );
      }

   /*
  agregarOrden(){
    if (this.ordenForm.valid) {
      const formulario: Orden = {
      fecha: this.ordenForm.get('fecha')?.value || '',
    };
    const Orden = this.ordenForm.value;
    console.log(formulario);
  }
  }*/ 

  /*agregarOrden ():void{
    const idsOrden = this.listOrden.map(orden => orden.id).filter(id => id !== null && id !== undefined);
    console.log("saaaaaaaaaaaaa");
    console.log(idsOrden);
     this.ultimoId = idsOrden[idsOrden.length - 1];
  console.log(this.ultimoId)
  const numeros = parseInt(this.ultimoId.match(/\d+$/)[0], 10);
  const numerosMasUno = numeros + 1; // Sumar 1
const nuevoUltimoId = this.ultimoId.replace(/\d+$/, numerosMasUno.toString().padStart(this.ultimoId.length - 3, "0"));
this.ordenForm.patchValue({ id: nuevoUltimoId });
console.log(this.ordenForm)
this.ordenService.crearOrden(this.ordenForm.value).subscribe(
  resp=>{
    console.log(resp)
    this.ordenForm.reset();
  },
  error=>{
    console.error(error)
  }
);
  }*/

  /*
  agregarOrden(): void {
    console.log(";skskksks")
    if (
      this.ordenForm.valid &&
      this.selectedCliente &&
      this.selectedArticulo
    ) {
      const formulario: Orden = {
        fecha: this.ordenForm.get('fecha')?.value || '',
        cliente: this.selectedCliente,
        articulo: this.selectedArticulo,
      };
console.log(formulario)
      this.ordenService.crearOrden(formulario).subscribe(
        (resp) => {
          console.log(resp);
          this.ordenForm.reset();
          this.selectedCliente = null;
          this.selectedArticulo = null;
        },
        (error) => {
          console.error(error);
        }
      );
    }
  }*/
}

