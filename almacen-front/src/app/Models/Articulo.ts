export class Articulo{
    nombre?: string;
    precio_u?: number;


    constructor(nombre: string, precio_u: number){
        this.nombre = nombre;
        this.precio_u= precio_u;
    }
}