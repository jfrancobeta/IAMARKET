import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioDTO } from '../../../core/models/Usuario/UsuarioDTO';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private API_URL = environment.apiUrl + 'usuarios';
  constructor(private http: HttpClient) { }


  getUserByUsername(username: string): Observable<UsuarioDTO> {
    return this.http.get<UsuarioDTO>(`${this.API_URL}/${username}`);
  }
}
