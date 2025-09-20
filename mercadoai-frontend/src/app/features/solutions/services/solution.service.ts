import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Page } from '../../../core/models/shared/page';
import { SolucionSummaryDTO } from '../../../core/models/Solucion/SolucionSummaryDTO';
import { SolucionDTO } from '../../../core/models/Solucion/SolucionDTO';
import { SolucionCreateDTO } from '../../../core/models/Solucion/SolutionCreateDTO';
import { SolucionUpdateDTO } from '../../../core/models/Solucion/SolucionUpdateDTO';
import { SolucionDetailsDTO } from '../../../core/models/Solucion/SolucionDetailsDTO';

@Injectable({
  providedIn: 'root',
})
export class SolutionService {
  private URL = environment.apiUrl + 'soluciones';

  constructor(private http: HttpClient) {}

  getAll(params: any): Observable<Page<SolucionSummaryDTO>> {
    return this.http.get<Page<SolucionSummaryDTO>>(`${this.URL}/`, { params });
  }

  getById(id: number): Observable<SolucionDetailsDTO> {
    return this.http.get<SolucionDetailsDTO>(`${this.URL}/${id}`);
  }

  create(solucion: SolucionCreateDTO): Observable<SolucionDTO> {
    return this.http.post<SolucionDTO>(this.URL + '/', solucion);
  }

  update(id: number, solucion: SolucionUpdateDTO): Observable<SolucionDTO> {
    return this.http.put<SolucionDTO>(`${this.URL}/${id}`, solucion);
  }
}
