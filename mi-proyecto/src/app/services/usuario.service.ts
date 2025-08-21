import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { Usuario } from '../models/usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
    private apiUrl = 'http://localhost:3030/usuario';

  constructor(private http: HttpClient) { }

  crearUsuario(usuario: Usuario): Observable<any> {
    return this.http.post<any>(this.apiUrl + '/guardar', usuario);
  }
  listarUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.apiUrl + '/buscar');
  }
  eliminarUsuario(id: string): Observable<any> {
    return this.http.delete<any>(this.apiUrl + '/eliminar/' + id);
  }
  actualizarUsuario(id: string, usuario: Usuario): Observable<any> {
    return this.http.put<any>(this.apiUrl + '/actualizar/' + id, usuario);
  }
}
