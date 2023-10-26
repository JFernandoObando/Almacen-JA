import { Articulo } from "./Articulo";
import { Cliente } from "./Cliente";

export class Orden{
    id?:String;
    fecha?: Date;
    cliente?: Cliente;
    articulo?: Articulo;


    constructor(id:String,fecha: Date,cliente :Cliente,articulo:Articulo){
        this.id=id;
        this.fecha= fecha;
        this.cliente=cliente;
        this.articulo=articulo;
    }
}