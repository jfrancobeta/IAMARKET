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
import { ProyectoDetailStatsDTO } from '../../../core/models/Proyecto/ProyectoDetailStatsDTO';
import { ProyectoStatsDTO } from '../../../core/models/Proyecto/ProyectoStatsDTO';

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

  deleteHito(proyectoId: number, hitoId: number): Observable<string> {
    return this.http.delete(`${this.apiUrl}/${proyectoId}/hitos/${hitoId}`, { responseType: 'text' });
  }

  requestCancel(id: number, reason: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/${id}/cancel-request`, reason, {
      headers: { 'Content-Type': 'application/json' }
    });
  }

  approveCancel(id: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/${id}/cancel-accept`, {});
  }

  getDetailStats(id: number): Observable<ProyectoDetailStatsDTO> {
    return this.http.get<ProyectoDetailStatsDTO>(`${this.apiUrl}/${id}/stats`);
  }

  getStats(): Observable<ProyectoStatsDTO> {
    return this.http.get<ProyectoStatsDTO>(`${this.apiUrl}/stats`);
  }

  rejectCancel(id: number, reason: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/${id}/cancel-reject`, reason, {
      headers: { 'Content-Type': 'application/json' }
    });
  }

  requestFinalize(id: number, reason?: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/${id}/finalize-request`, reason ?? null, {
      headers: { 'Content-Type': 'application/json' }
    });
  }

  approveFinalize(id: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/${id}/finalize-approve`, {});
  }

  rejectFinalize(id: number, reason?: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/${id}/finalize-reject`, reason ?? null, {
      headers: { 'Content-Type': 'application/json' }
    });
  }

  finalizeDirect(id: number, force: boolean, reason?: string): Observable<any> {
    // force flag passed as query param when true
    const url = `${this.apiUrl}/${id}/finalize-direct${force ? '?force=true' : ''}`;
    return this.http.post(url, reason ?? null, {
      headers: { 'Content-Type': 'application/json' }
    });
  }

  getFinalizeChecklist(id: number): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/${id}/finalize-checklist`);
  }
}

