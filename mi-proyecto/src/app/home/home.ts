import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule} from '@angular/forms';
import { Router } from '@angular/router';
import { Modulo } from '../models/modulo';
import { UsuarioMenuService } from '../services/usuario-menu.service';
import { MenuHeaderComponent } from '../menu-header/menu-header.component';



@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, MenuHeaderComponent], // 👈 AQUI
  templateUrl: './home.html',
  styleUrls: ['./home.css']

})
export class Home {
  modulos: Modulo[] = [];


  constructor(
    private router: Router,
    private usuarioMenuService: UsuarioMenuService
  ) {  }





  Regresar() {
    this.router.navigate(['/']);
  }





  
}
