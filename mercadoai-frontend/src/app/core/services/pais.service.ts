import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { PaisDTO } from '../models/Pais/PaisDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaisService {

  private apiUrl: string = environment.apiUrl + 'paises';

  constructor(private http: HttpClient) { }

  getPaises(): Observable<PaisDTO[]> {
    return this.http.get<PaisDTO[]>(this.apiUrl + '/');
  }
}
