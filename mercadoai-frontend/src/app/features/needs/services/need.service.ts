import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';
import { NecesidadCreateDTO } from '../../../core/models/Necesidad/NecesidadCreateDTO';
import { NecesidadDTO } from '../../../core/models/Necesidad/NecesidadDTO';
import { NecesidadSummaryDTO } from '../../../core/models/Necesidad/NecesidadSummaryDTO';
import { NecesidadUserDetailsDTO } from '../../../core/models/Necesidad/NecesidadUserDetailsDTO';
import { Page } from '../../../core/models/shared/page';

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
