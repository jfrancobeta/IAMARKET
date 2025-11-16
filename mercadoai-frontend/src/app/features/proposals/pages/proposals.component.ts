import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { PropuestaSummaryDTO } from '../../../core/models/Propuesta/PropuestaSummaryDTO';
import { PropuestaService } from '../services/propuesta.service';
import { Page } from '../../../core/models/shared/page';
import { EstadoDTO } from '../../../core/models/Estado/EstadoDTO';
import { EstadoService } from '../../../core/services/estado.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-proposals',
  standalone: true,
  imports: [MainLayoutComponent, RouterModule, CommonModule, FormsModule],
  templateUrl: './proposals.component.html',
})
export class ProposalsComponent implements OnInit {
  propuestasEnviadas: PropuestaSummaryDTO[] = [];
  propuestasRecibidas: PropuestaSummaryDTO[] = [];

  estados: EstadoDTO[] = [];

  totalSent = 0;
  totalReceived = 0;
  pageSent = 0;
  pageReceived = 0;
  size = 10;
  search = '';
  estado = '';

  constructor(
    private propuestaService: PropuestaService,
    private estadoService: EstadoService
  ) {}

  ngOnInit(): void {
    this.loadPropuestasEnviadas();
    this.loadPropuestasRecibidas();
    this.loadEstados();
  }
  loadEstados(): void {
    this.estadoService.getAll().subscribe({
      next: (data) => {
        this.estados = data;
      },
    });
  }

  loadPropuestasEnviadas(): void {
    const params: any = {
      page: this.pageSent,
      size: this.size,
    };
    if (this.search) params.search = this.search;
    if (this.estado) params.estado = this.estado;

    this.propuestaService.getAllSent(params).subscribe({
      next: (page: Page<PropuestaSummaryDTO>) => {
        console.log(page);
        this.propuestasEnviadas = page.content;
        this.totalSent = page.totalElements;
        console.log(this.propuestasEnviadas);
      },
    });
  }

  loadPropuestasRecibidas(): void {
    const params: any = {
      page: this.pageReceived,
      size: this.size,
    };
    this.propuestaService.getAllReceived(params).subscribe({
      next: (page: Page<PropuestaSummaryDTO>) => {
        console.log(page);
        this.propuestasRecibidas = page.content;
        this.totalReceived = page.totalElements;
        console.log('recibidas', this.propuestasRecibidas);
      },
    });
  }

  getSemanasEntreFechas(fechaCreacion: string, fechaEntrega: string): string {
    if (!fechaCreacion || !fechaEntrega) return '';
    const inicio = new Date(fechaCreacion);
    const fin = new Date(fechaEntrega);
    const diffMs = fin.getTime() - inicio.getTime();
    const diffDias = Math.ceil(diffMs / (1000 * 60 * 60 * 24));
    const semanas = Math.max(1, Math.round(diffDias / 7));
    return `${semanas} semana${semanas > 1 ? 's' : ''}`;
  }

  aceptarPropuesta(id: number): void {
    this.propuestaService.aceptarPropuesta(id).subscribe({
      next: () => {
        this.loadPropuestasRecibidas();
      },
    });
  }

  rechazarPropuesta(id: number): void {
    this.propuestaService.rechazarPropuesta(id).subscribe({
      next: () => {
        Swal.fire({
          icon: 'success',
          title: '¡Propuesta aceptada!',
          text: 'Se ha creado un pago. Realiza el pago para iniciar el proyecto.',
          confirmButtonText: 'Aceptar',
        });
        this.loadPropuestasRecibidas();
      },
      error: (err) => {
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text:
            err?.error?.message ||
            'No se pudo aceptar la propuesta. Intenta nuevamente.',
          confirmButtonText: 'Cerrar',
        });
        console.error(err);
      },
    });
  }
}
