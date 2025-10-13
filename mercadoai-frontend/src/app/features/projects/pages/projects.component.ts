import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { ProyectoService } from '../services/proyecto.service';
import { ProyectoDTO } from '../../../core/models/Proyecto/ProyectoDTO';
import { ProyectoSummaryDTO } from '../../../core/models/Proyecto/ProyectoSummaryDTO';
import { EstadoDTO } from '../../../core/models/Estado/EstadoDTO';
import { EstadoService } from '../../../core/services/estado.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [MainLayoutComponent, CommonModule, FormsModule, RouterModule],
  templateUrl: './projects.component.html',
})
export class ProjectsComponent implements OnInit {
  proyectos: ProyectoSummaryDTO[] = [];
  totalPages = 0;

  filtros = {
    page: 0,
    size: 10,
    estado: '',
    tipo: '',
    search: '',
  };

  estados: EstadoDTO[] = [];

  constructor(
    private proyectoService: ProyectoService,
    private estadoService: EstadoService
  ) {}

  ngOnInit(): void {
    this.loadProjects();
    this.loadEstados();
  }

  loadProjects(): void {
    this.proyectoService.getAll(this.filtros).subscribe((page) => {
      this.proyectos = page.content;
      this.totalPages = page.totalPages;
      console.log(this.proyectos);
    });
  }

  loadEstados(): void {
    this.estadoService.getAll().subscribe((data) => {
      this.estados = data;
    });
  }

  // ...existing code...

  getDiasRestantes(item: any): string {
    // Si hay solución, calcula como antes
    if (item.solucion) {
      const solucion = item.solucion;
      if (
        !solucion.fechaCreacion ||
        !solucion.tiempoEntrega ||
        !solucion.unidadEntrega
      ) {
        return '-';
      }
      const fechaInicio = new Date(solucion.fechaCreacion);
      let fechaEntrega = new Date(fechaInicio);

      switch (solucion.unidadEntrega) {
        case 'DIAS':
          fechaEntrega.setDate(fechaEntrega.getDate() + solucion.tiempoEntrega);
          break;
        case 'SEMANAS':
          fechaEntrega.setDate(
            fechaEntrega.getDate() + solucion.tiempoEntrega * 7
          );
          break;
        case 'MESES':
          fechaEntrega.setMonth(
            fechaEntrega.getMonth() + solucion.tiempoEntrega
          );
          break;
        default:
          fechaEntrega.setDate(fechaEntrega.getDate() + solucion.tiempoEntrega);
      }

      const hoy = new Date();
      const diffMs = fechaEntrega.getTime() - hoy.getTime();
      const diffDias = Math.ceil(diffMs / (1000 * 60 * 60 * 24));
      if (diffDias < 0) return 'Finalizado';
      return `${diffDias} días`;
    }

    if (item.propuesta && item.propuesta.entrega) {
      const fechaEntrega = new Date(item.propuesta.entrega);
      const hoy = new Date();
      const diffMs = fechaEntrega.getTime() - hoy.getTime();
      const diffDias = Math.ceil(diffMs / (1000 * 60 * 60 * 24));
      if (diffDias < 0) return 'Finalizado';
      return `${diffDias} días`;
    }

    return '-';
  }
}
