import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule} from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { Modulo } from '../models/modulo';
import { UsuarioMenuService } from '../services/usuario-menu.service';

@Component({
  selector: 'app-menu-header',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, CommonModule,  RouterModule],
  templateUrl: './menu-header.component.html',
  styleUrl: './menu-header.component.css'
})
export class MenuHeaderComponent {
 modulos: Modulo[] = [];
  menuVisible = false;
  miVariable: any[] = [];
  id: number = 0;

    temporal:any ={};
  public usuarioMomentaneo:any = {};

  constructor(
    private router: Router,
    private usuarioMenuService: UsuarioMenuService
  ) {}

  ngOnInit(): void {

  if (typeof window !== 'undefined' && window.localStorage) {
    this.temporal = JSON.parse(window.localStorage.getItem("usuario") || '{}');
     this.id = this.temporal.idRol;
           this.cargarModulos(this.id);
  }



}

 




  

  // Toggle del menú hamburguesa en móvil
  toggleMenu(): void {
    this.menuVisible = !this.menuVisible;
  }

  // Cargar módulos desde el servicio
  cargarModulos(idRol: number): void {
    this.usuarioMenuService.getUsuarioMenu(idRol).subscribe({
      next: (data) => {
        this.modulos = data;
        console.log('Módulos cargados:', JSON.stringify(this.modulos, null, 2));
      },
      error: (err) => {
        console.error('Error al obtener módulos:', err);
      }
    });
  }

  // Navegar a la ruta seleccionada
  irA(url: string): void {
    this.menuVisible = false; // cerrar menú en móvil al navegar
    this.router.navigateByUrl(url);
  }
}
