import { Component } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, Validators, FormGroup, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { UsuarioService } from '../services/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-usuario',
  imports: [ReactiveFormsModule, CommonModule, FormsModule],
  templateUrl: './crear-usuario.component.html',
  styleUrl: './crear-usuario.component.css'
})
export class CrearUsuarioComponent {
  crearUsuarioForm: FormGroup;
  loading: boolean = false;
  errorInicio: boolean = false;
  usuario: any = {};
  message: string = '';
  constructor(private fb: FormBuilder, private http: HttpClient, private usuarioService: UsuarioService, private router: Router) {
    this.crearUsuarioForm = this.fb.group({
      //idusuario: ['', Validators.required],
      nombreCompleto: ['', Validators.required],
      correoElectronico: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      rolIdrol: ['', Validators.required]
    });
  }

  crearUsuario() {
    if (this.crearUsuarioForm.invalid) {
      this.message = 'Por favor, completa todos los campos correctamente.';
      return;
    }
    this.loading = true;
    this.usuarioService.crearUsuario(this.crearUsuarioForm.value).subscribe({
      next: (respuesta) => {
        this.loading = false;
        this.message = respuesta.message;

        setTimeout(() => {
          this.crearUsuarioForm.reset();
          this.message = '';
        }, 5000);

        if (respuesta.usuario) {

          this.router.navigate(['/home']);
        }
      },
      error: (err) => {

        this.loading = false;
        if (err.error?.message) {
            this.message = err.error.message;
        } else {
           this.message = 'Error desconocido. Código: ' + err.status;
        }
        setTimeout(() => {
          this.message = '';
        }, 5000);
      }

    });
  }




}
