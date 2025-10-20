import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { Observable } from 'rxjs';
import { ProyectoCreateDTO } from '../../../core/models/Proyecto/ProyectoCreateDTO';
import { ProyectoDTO } from '../../../core/models/Proyecto/ProyectoDTO';
import { ProyectoSummaryDTO } from '../../../core/models/Proyecto/ProyectoSummaryDTO';
import { ProyectoUpdateDTO } from '../../../core/models/Proyecto/ProyectoUpdateDTO';
import { Page } from '../../../core/models/shared/page';
import { HitoCreateDTO } from '../../../core/models/Hito/HitoCreateDTO';
import { HitoDTO } from '../../../core/models/Hito/HitoDTO';
import { HitoUpdateDTO } from '../../../core/models/Hito/HitoUpdateDTO';

@Injectable({
  providedIn: 'root',
})
export class ProyectoService {
  private apiUrl = environment.apiUrl + 'proyectos';

  constructor(private http: HttpClient) {}

  getAll(params: any): Observable<Page<ProyectoSummaryDTO>> {
    return this.http.get<Page<ProyectoSummaryDTO>>(`${this.apiUrl}/`, {
      params,
    });
  }

  getById(id: number): Observable<ProyectoDTO> {
    return this.http.get<ProyectoDTO>(`${this.apiUrl}/${id}`);
  }

  crear(dto: ProyectoCreateDTO): Observable<ProyectoDTO> {
    return this.http.post<ProyectoDTO>(`${this.apiUrl}/`, dto);
  }

  actualizar(id: number, dto: ProyectoUpdateDTO): Observable<ProyectoDTO> {
    return this.http.put<ProyectoDTO>(`${this.apiUrl}/${id}`, dto);
  }

  eliminar(id: number): Observable<string> {
    return this.http.delete(`${this.apiUrl}/${id}`, { responseType: 'text' });
  }

  addHito(proyectoId: number, dto: HitoCreateDTO): Observable<HitoDTO> {
    return this.http.post<HitoDTO>(`${this.apiUrl}/${proyectoId}/hitos`, dto);
  }
  editarHito(
    proyectoId: number,
    hitoId: number,
    dto: HitoUpdateDTO
  ): Observable<HitoDTO> {
    return this.http.put<HitoDTO>(
      `${this.apiUrl}/${proyectoId}/hitos/${hitoId}`,
      dto
    );
  }

  requestCancel(id: number, reason: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/${id}/cancel-request`, reason, {
      headers: { 'Content-Type': 'application/json' }
    });
  }

  approveCancel(id: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/${id}/cancel-accept`, {});
  }

  rejectCancel(id: number, reason: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/${id}/cancel-reject`, reason, {
      headers: { 'Content-Type': 'application/json' }
    });
  }
}
