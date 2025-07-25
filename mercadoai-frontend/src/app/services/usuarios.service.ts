import { Injectable } from '@angular/core';
import { RegistroRequest } from '../models/RegistroRequest';
import { Observable } from 'rxjs';
import { User } from '../models/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private url : string = 'http://localhost:8081/usuarios';

  constructor(private http: HttpClient) { }


  registrarUsuario(usuario: RegistroRequest): Observable<any> {
    return this.http.post<any>(this.url + '/usuario', usuario);
  }


}
