import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { IndustriaDTO } from '../models/Industria/IndustriaDTO';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IndustriaService {

  private apiUrl: string = environment.apiUrl + 'industrias';
  constructor(private http: HttpClient) { }

  getIndustrias(): Observable<IndustriaDTO[]> {
    return this.http.get<IndustriaDTO[]>(this.apiUrl + '/');
  }
}
