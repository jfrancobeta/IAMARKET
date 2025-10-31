import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { RatingDTO } from '../../../core/models/Rating/RatingDTO';
import { RatingService } from '../services/rating.service';
import { PendingRatingDTO } from '../../../core/models/Rating/PendingRatingDTO';
import { CommonModule } from '@angular/common';
import { CompleteRatingDTO } from '../../../core/models/Rating/CompleteRatingDTO';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-rating',
  standalone: true,
  imports: [MainLayoutComponent, CommonModule, FormsModule],
  templateUrl: './rating.component.html',
})
export class RatingComponent implements OnInit {
  ratingsReceived: RatingDTO[] = [];
  ratingsGiven: RatingDTO[] = [];
  pendingRatings: PendingRatingDTO[] = [];
  loading: boolean = false;

  submitting: boolean = false;
  selectedPendingRating: PendingRatingDTO | null = null;
  completeRating: CompleteRatingDTO = {
    calificacion: 0,
    comentario: '',
  };


  constructor(private ratingService: RatingService) {}

  ngOnInit(): void {
    this.loadRatings();
    console.log(this.pendingRatings);
  }

  loadRatings() {
    this.loading = true;
    // Recibidas
    this.ratingService.getRatingsReceived().subscribe({
      next: (data) => (this.ratingsReceived = data),
      error: () => (this.ratingsReceived = []),
    });
    // Enviadas
    this.ratingService.getRatingsGiven().subscribe({
      next: (data) => (this.ratingsGiven = data),
      error: () => (this.ratingsGiven = []),
    });
    // Pendientes (puede ser solo una, pero lo manejamos como array por si acaso)
    this.ratingService.getPendingRating().subscribe({
      next: (pending) => {
        this.pendingRatings = pending;
        this.loading = false;
      },
      error: () => {
        this.pendingRatings = [];
        this.loading = false;
      },
    });
  }
  openCalificarModal(pending: PendingRatingDTO) {
    this.selectedPendingRating = pending;
    this.completeRating = { calificacion: 0, comentario: '' };
    setTimeout(() => {
      (window as any).bootstrap.Modal.getOrCreateInstance(
        document.getElementById('calificarModal')
      ).show();
    }, 0);
  }

  submitRating() {
    if (!this.selectedPendingRating || this.completeRating.calificacion < 1)
      return;
    this.submitting = true;
    this.ratingService
      .completeRating(this.selectedPendingRating.id, this.completeRating)
      .subscribe({
        next: () => {
          this.submitting = false;
          (window as any).bootstrap.Modal.getOrCreateInstance(
            document.getElementById('calificarModal')
          ).hide();
          this.selectedPendingRating = null;
          this.loadRatings();
        },
        error: () => {
          this.submitting = false;
          alert('Error al enviar la calificación');
        },
      });
  }

  get averageRating(): number {
    if (!this.ratingsReceived.length) return 0;
    const sum = this.ratingsReceived.reduce(
      (acc, r) => acc + (r.calificacion || 0),
      0
    );
    return +(sum / this.ratingsReceived.length).toFixed(2);
  }

  get positiveReviews(): number {
    // Considera positivas las de 4 o 5 estrellas
    return this.ratingsReceived.filter((r) => r.calificacion >= 4).length;
  }

  get positivePercentage(): number {
    if (!this.ratingsReceived.length) return 0;
    return Math.round(
      (this.positiveReviews / this.ratingsReceived.length) * 100
    );
  }

  get pendingCount(): number {
    return this.pendingRatings.length;
  }

  get reviewsCount(): number {
    return this.ratingsReceived.length;
  }
  round(value: number): number {
  return Math.round(value);
}
}
