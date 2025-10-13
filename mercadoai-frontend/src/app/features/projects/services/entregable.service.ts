import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EntregableDTO } from '../../../core/models/Entregable/EntregableDTO';

@Injectable({
  providedIn: 'root',
})
export class EntregableService {
  private apiUrl = environment.apiUrl + 'entregables';
  constructor(private http: HttpClient) {}

  uploadEntregable(
    entregableId: number,
    file: File
  ): Observable<EntregableDTO> {
    const formData = new FormData();
    formData.append('file', file);
    return this.http.post<EntregableDTO>(
      `${this.apiUrl}/${entregableId}/upload`,
      formData
    );
  }

  aprobarEntregable(entregableId: number): Observable<EntregableDTO> {
    return this.http.post<EntregableDTO>(
      `${this.apiUrl}/${entregableId}/aprobar`,
      {}
    );
  }

  rechazarEntregable(entregableId: number): Observable<EntregableDTO> {
    return this.http.post<EntregableDTO>(
      `${this.apiUrl}/${entregableId}/rechazar`,
      {}
    );
  }
  downloadEntregable(entregableId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${entregableId}/download`, {
      responseType: 'blob',
      observe: 'response',
    });
  }
}
