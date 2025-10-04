import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../../shared/layout/main-layout/main-layout.component';
import { PropuestaDTO } from '../../../../core/models/Propuesta/PropuestaDTO';
import { PropuestaService } from '../../services/propuesta.service';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CurrencyPipe, DatePipe } from '@angular/common';

@Component({
  selector: 'app-details-proposal',
  standalone: true,
  imports: [MainLayoutComponent, RouterLink, DatePipe, CurrencyPipe],
  templateUrl: './details-proposal.component.html',
})
export class DetailsProposalComponent implements OnInit {

  propuesta!: PropuestaDTO;

  constructor(private propuestaService: PropuestaService,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.cargarPropuesta();
  }

  cargarPropuesta(): void {
    const propuestaId = this.route.snapshot.paramMap.get('id');
    if (propuestaId) {
      this.propuestaService.getById(Number(propuestaId)).subscribe({
        next: (data) => {
          this.propuesta = data;
        },
        error: (err) => {
          console.error('Error al cargar la propuesta:', err);
        }
      });
    }
  }

}
