import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { Observable } from 'rxjs';
import { PropuestaCreateDTO } from '../../../core/models/Propuesta/PropuestaCreateDTO';
import { PropuestaDTO } from '../../../core/models/Propuesta/PropuestaDTO';
import { PropuestaUpdateDTO } from '../../../core/models/Propuesta/PropuestaUpdateDTO';
import { PropuestaSummaryDTO } from '../../../core/models/Propuesta/PropuestaSummaryDTO';
import { Page } from '../../../core/models/shared/page';

@Injectable({
  providedIn: 'root',
})
export class PropuestaService {
  private apiUrl = environment.apiUrl + 'propuestas';

  constructor(private http: HttpClient) {}

  getAllSent(params: any): Observable<Page<PropuestaSummaryDTO>> {
    return this.http.get<Page<PropuestaSummaryDTO>>(`${this.apiUrl}/sent`, { params });
  }
  getAllReceived(params: any): Observable<Page<PropuestaSummaryDTO>> {
    return this.http.get<Page<PropuestaSummaryDTO>>(`${this.apiUrl}/received`, { params });
  }
  getById(id: number): Observable<PropuestaDTO> {
    return this.http.get<PropuestaDTO>(`${this.apiUrl}/${id}`);
  }

  create(propuesta: PropuestaCreateDTO): Observable<PropuestaDTO> {
    return this.http.post<PropuestaDTO>(this.apiUrl, propuesta);
  }

  update(id: number, propuesta: PropuestaUpdateDTO): Observable<PropuestaDTO> {
    return this.http.put<PropuestaDTO>(`${this.apiUrl}/${id}`, propuesta);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
