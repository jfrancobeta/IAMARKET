import { Injectable } from '@angular/core';
import { RegistroRequest } from '../models/RegistroRequest';
import { Observable } from 'rxjs';
import { Usuario } from '../models/Usuario';
import { HttpClient } from '@angular/common/http';
import { ResetCodeRequest, ResetPasswordRequest, VerifyCodeRequest } from '../models/auth-reset.model';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private url : string =  environment.apiUrl + 'usuarios';

  constructor(private http: HttpClient) { }


  registrarUsuario(usuario: RegistroRequest): Observable<any> {
    return this.http.post<any>(this.url + '/create-user', usuario);
  }

  sendResetCode(data: ResetCodeRequest): Observable<boolean> {
    return this.http.post<any>(`${this.url}/send-reset-code`, data);
  }

  // Verificar código de recuperación
  verifyResetCode(data: VerifyCodeRequest): Observable<boolean> {
    return this.http.post<any>(`${this.url}/verify-reset-code`, data);
  }

  // Resetear contraseña
  resetPassword(data: ResetPasswordRequest): Observable<boolean> {
    return this.http.post<any>(`${this.url}/reset-password`, data);
  }


}
