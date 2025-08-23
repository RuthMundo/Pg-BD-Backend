import { Routes } from '@angular/router';
import { Login } from './login/login';
import { Home } from './home/home';
import { Inicio } from './inicio/inicio';
import { CrearUsuarioComponent } from './crear-usuario/crear-usuario.component';



export const routes: Routes = [
    {
        path:"" , 
        component:Login
    },
    {
        path:"home" , 
        component:Home
    },
    {
        path:"inicio" , 
        component:Inicio
    },
    {
        path:"crear-usuario" , 
        component:CrearUsuarioComponent
    }
];

