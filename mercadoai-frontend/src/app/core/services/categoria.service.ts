import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { CategoriaDTO } from '../models/Categoria/CategoriaDTO';
import { NecesidadSummaryDTO } from '../models/Necesidad/NecesidadSummaryDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  private apiUrl = environment.apiUrl + 'categorias'
  constructor(
    private http: HttpClient
  ) { }

  getAll(): Observable<CategoriaDTO[]> {
      return this.http.get<CategoriaDTO[]>(`${this.apiUrl}/`);
    }

}
