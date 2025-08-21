import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Router } from 'express';
import { ReactiveFormsModule, FormBuilder, Validators,FormGroup } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpClient, HttpHeaders } from '@angular/common/http';



@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, HttpClientModule], // 👈 AQUI
  templateUrl: './login.html',
  styleUrl: './login.css'

})
export class Login {

  loginForm: FormGroup;
  loading:boolean = false;
  errorInicio:boolean = false;
  usuario:any ={};

  constructor(private fb: FormBuilder,private http: HttpClient) {
    // Inicializamos el formulario en el constructor (más seguro)
    this.loginForm = this.fb.group({
      correoElectronico: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }
  
  login() {
    if (this.loginForm.valid) {
      this.loading = true;
      this.errorInicio = false;

      // Simulación de petición al backend
      setTimeout(() => {
        this.loading = false;

        const { correoElectronico, password } = this.loginForm.value;
        if (correoElectronico === 'test@correo.com' && password === '1234') {
          alert('✅ Login exitoso');
        } else {
          this.errorInicio = true;
        }
      }, 2000);
    } else {
      this.loginForm.markAllAsTouched();
    }
  }

  iniciarSesion(resulado:any){
    this.loading= false;
  
  }

  loginService(){
  const HttpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

this.http.post("http://localhost:3030/usuario/login", this.usuario, HttpOptions)
  .subscribe(res => {
    console.log(res);
  });
  }

  crearCuenta() {
    location.href="/home";
  }
  
}
