import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Necesidad } from '../models/need/Necesidad';
import { NecesidadDTO } from '../models/need/NecesidadDTO';
import { environment } from '../environments/environment';
import { NecesidadSummaryDTO } from '../models/need/NecesidadSummaryDTO';
import { NecesidadResponseDTO } from '../models/need/NecesidadResponseDTO';

@Injectable({
  providedIn: 'root'
})
export class NeedService {
  private url = environment.apiUrl + 'necesidades';

  constructor(private http: HttpClient) {}

  getAll(): Observable<NecesidadSummaryDTO[]> {
    return this.http.get<NecesidadSummaryDTO[]>(`${this.url}/`);
  }

  getById(id: number): Observable<NecesidadResponseDTO> {
    return this.http.get<NecesidadResponseDTO>(`${this.url}/${id}`);
  }

  create(necesidad: NecesidadDTO): Observable<Necesidad> {
    return this.http.post<Necesidad>(`${this.url}/`, necesidad);
  }

  update(id: number, necesidad: NecesidadDTO): Observable<Necesidad> {
    return this.http.put<Necesidad>(`${this.url}/${id}`, necesidad);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/eliminar/${id}`);
  }
}
