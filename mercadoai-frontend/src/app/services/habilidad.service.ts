
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HabilidadDTO } from '../models/Habilidad/HabilidadDTO';
import { HabilidadCreateDTO } from '../models/Habilidad/HabilidadCreateDTO';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HabilidadService {
  private apiUrl = environment.apiUrl + 'habilidades'; // Ajusta la URL base según tu backend

  constructor(private http: HttpClient) { }

  getAll(): Observable<HabilidadDTO[]> {
    return this.http.get<HabilidadDTO[]>(`${this.apiUrl}/`);
  }

  getById(id: number): Observable<HabilidadDTO> {
    return this.http.get<HabilidadDTO>(`${this.apiUrl}/${id}`);
  }

  create(habilidad: HabilidadCreateDTO): Observable<HabilidadDTO> {
    return this.http.post<HabilidadDTO>(`${this.apiUrl}/`, habilidad);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
