import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './Components/menu/menu.component';

import { ClienteComponent} from './Components/cliente/cliente.component';
import { ClienteIngresoComponent} from './Components/cliente-ingreso/cliente-ingreso.component';
import { ArticulosComponent} from './Components/articulos/articulos.component';
import { OrdenComponent} from './Components/orden/orden.component';

const routes: Routes = [ 
  { path: '',component: ClienteComponent},
  {path: 'cliente',component: ClienteComponent},
  {path: 'cliente',component: ClienteComponent},
  {path: 'articulos',component: ArticulosComponent},
  {path: 'orden',component: OrdenComponent}
  

];


  

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

  
}
