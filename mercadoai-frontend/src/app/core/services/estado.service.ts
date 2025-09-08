import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EstadoDTO } from '../models/Estado/EstadoDTO';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  private API_URL = environment.apiUrl + 'estados';
  constructor(private http: HttpClient) { }

  getAll(): Observable<EstadoDTO[]> {
    return this.http.get<EstadoDTO[]>(`${this.API_URL}/`);
  }
}
