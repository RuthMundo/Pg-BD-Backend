import { Component } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, Validators, FormGroup, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClient} from '@angular/common/http';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, FormsModule], // 👈 AQUI
  templateUrl: './login.html',
  styleUrl: './login.css'

})
export class Login {

  loginForm: FormGroup;
  loading: boolean = false;
  errorInicio: boolean = false;
  usuario: any = {};
  message: string = '';

  constructor(private fb: FormBuilder, private http: HttpClient, private loginServiceC: LoginService, private router: Router) {
    // Inicializamos el formulario en el constructor (más seguro)
    this.loginForm = this.fb.group({
      correoElectronico: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }


  ngOnInit() {

  }



  crearCuenta() {
    //location.href = "/home";

    //this.router.navigate(['/crear-usuario']);
    location.href = "/crear-usuario";
  }


  loginc() {
    if (this.loginForm.invalid) {
      this.message = 'Por favor, completa todos los campos correctamente.';
      return;
    }
    this.loading = true;
    this.loginServiceC.login(this.loginForm.value).subscribe({
      next: (respuesta) => {
        this.loading = false;
        this.message = respuesta.message;



        if (respuesta.usuario) {
          // 👇 aquí deberías usar Router, no location.href
          this.router.navigate(['/home']);
        }
      },
      error: (err) => {

        this.loading = false;
        if (err.error?.message) {
          alert(err.error.message);
        } else {
          alert('Error desconocido. Código: ' + err.status);
        }
      }

    });
  }
}