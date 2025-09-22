import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Modulo } from '../models/modulo';

@Injectable({
  providedIn: 'root'
})
export class UsuarioMenuService {
  private apiUrl = 'http://localhost:3030/usuarioMenu';

  constructor(private http: HttpClient) { }

  getUsuarioMenu(idRol: Number): Observable<Modulo[]> {
    return this.http.get<Modulo[]>(this.apiUrl + '/usuarioMenu2/' + idRol);
  }
}
