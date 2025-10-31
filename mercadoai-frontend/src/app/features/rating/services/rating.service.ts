import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { Observable } from 'rxjs';
import { CompleteRatingDTO } from '../../../core/models/Rating/CompleteRatingDTO';
import { PendingRatingDTO } from '../../../core/models/Rating/PendingRatingDTO';
import { RatingDTO } from '../../../core/models/Rating/RatingDTO';

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  private BASE_URL = `${environment.apiUrl}ratings`;

  constructor(private http: HttpClient) { }

  completeRating(id: number, dto: CompleteRatingDTO): Observable<RatingDTO> {
    return this.http.post<RatingDTO>(`${this.BASE_URL}/${id}/complete`, dto);
  }

  // Obtener la próxima calificación pendiente para el usuario autenticado
  getPendingRating(): Observable<PendingRatingDTO[]> {
    return this.http.get<PendingRatingDTO[]>(`${this.BASE_URL}/pending`);
  }

  // Obtener calificaciones recibidas por el usuario autenticado
  getRatingsReceived(): Observable<RatingDTO[]> {
    return this.http.get<RatingDTO[]>(`${this.BASE_URL}/received`);
  }

  // Obtener calificaciones dadas por el usuario autenticado
  getRatingsGiven(): Observable<RatingDTO[]> {
    return this.http.get<RatingDTO[]>(`${this.BASE_URL}/given`);
  }

  // Obtener calificaciones de un proyecto
  getRatingsByProject(projectId: number): Observable<RatingDTO[]> {
    return this.http.get<RatingDTO[]>(`${this.BASE_URL}/project/${projectId}`);
  }
}
