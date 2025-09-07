import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NecesidadDTO } from '../models/Necesidad/NecesidadDTO';
import { environment } from '../../environments/environment';
import { NecesidadSummaryDTO } from '../models/Necesidad/NecesidadSummaryDTO';
import { NecesidadUserDetailsDTO } from '../models/Necesidad/NecesidadUserDetailsDTO';
import { NecesidadCreateDTO } from '../models/Necesidad/NecesidadCreateDTO';
import { Page } from '../models/page';

@Injectable({
  providedIn: 'root'
})
export class NeedService {
  private url = environment.apiUrl + 'necesidades';

  constructor(private http: HttpClient) {}

  getAll(params:any): Observable<Page<NecesidadSummaryDTO>> {
    return this.http.get<Page<NecesidadSummaryDTO>>(`${this.url}/`, { params });
  }

  getByidDetails(id: number): Observable<NecesidadUserDetailsDTO> {
    return this.http.get<NecesidadUserDetailsDTO>(`${this.url}/${id}/details`);
  }

  getById(id: number): Observable<NecesidadDTO> {
    return this.http.get<NecesidadDTO>(`${this.url}/${id}`);
  }

  create(necesidad: NecesidadCreateDTO): Observable<NecesidadDTO> {
    return this.http.post<NecesidadDTO>(`${this.url}/`, necesidad);
  }

  update(id: number, necesidad: NecesidadCreateDTO): Observable<NecesidadDTO> {
    return this.http.put<NecesidadDTO>(`${this.url}/${id}`, necesidad);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }
}
