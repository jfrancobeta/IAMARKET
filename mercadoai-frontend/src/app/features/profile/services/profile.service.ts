import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioDTO } from '../../../core/models/Usuario/UsuarioDTO';
import { PerfilDesarrolladorDTO } from '../../../core/models/Perfil/PerfilDesarrolladorDTO';
import { ProfileDeveloperUpdateDTO } from '../../../core/models/Perfil/ProfileDeveloperUpdateDTO';
import { UserPersonalUpdateDTO } from '../../../core/models/Usuario/UserPersonalUpdateDTO';

@Injectable({
  providedIn: 'root',
})
export class ProfileService {
  private API_URL = environment.apiUrl + 'usuarios';
  constructor(private http: HttpClient) {}

  getUserByUsername(username: string): Observable<UsuarioDTO> {
    return this.http.get<UsuarioDTO>(`${this.API_URL}/${username}`);
  }

  // 1. Actualizar datos personales
  updateUserPersonal(id: number, data: UserPersonalUpdateDTO): Observable<UsuarioDTO> {
    return this.http.put<UsuarioDTO>(`${this.API_URL}/${id}/personal-data`, data);
  }

  // 2. Subir foto de perfil
  uploadProfilePhoto(id: number, file: File): Observable<string> {
    const formData = new FormData();
    formData.append('file', file);

    return this.http.post(`${this.API_URL}/${id}/profile-photo`, formData, {
      responseType: 'text'
    });
  }

  // 3. Actualizar perfil de desarrollador
  updateDeveloperProfile(id: number, data: ProfileDeveloperUpdateDTO): Observable<PerfilDesarrolladorDTO> {
    return this.http.put<PerfilDesarrolladorDTO>(`${this.API_URL}/${id}/developer-profile`, data);
  }
}
