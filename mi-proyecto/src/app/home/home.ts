import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, Validators, NonNullableFormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClientModule, HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, HttpClientModule], // 👈 AQUI
  templateUrl: './home.html',
  styleUrls: ['./home.css']

})
export class Home {
  loading = false;
  loginForm: FormGroup; // 👈 declaramos primero
  usuario:any ={};


  constructor(
    private fb: NonNullableFormBuilder,
    private router: Router,
    private http: HttpClient
  ) {
    // 👇 aquí sí podemos usar this.fb porque ya fue inyectado
    this.loginForm = this.fb.group({
      correoElectronico: ['', [Validators.required, Validators.email]],
      NombreCompleto: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  crear() {
    if (this.loginForm.valid) {
      this.loading = true;
      console.log('📩 Datos enviados:', this.loginForm.value);

      setTimeout(() => {
        this.loading = false;
        alert('✅ Cuenta creada con éxito');
        this.loginForm.reset();
      }, 2000);
    } else {
      this.loginForm.markAllAsTouched();
    }
  }

  crearService(){
  const HttpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

this.http.post("http://localhost:3030/usuario/guardar", this.usuario, HttpOptions)
  .subscribe(res => {
    console.log(res);
  });
  }

  Regresar() {
    this.router.navigate(['/login']);
  }
}
