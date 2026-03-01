import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { ProyectoService } from '../services/proyecto.service';
import { ProyectoDTO } from '../../../core/models/Proyecto/ProyectoDTO';
import { ProyectoSummaryDTO } from '../../../core/models/Proyecto/ProyectoSummaryDTO';
import { EstadoDTO } from '../../../core/models/Estado/EstadoDTO';
import { EstadoService } from '../../../core/services/estado.service';
import { ChatService } from '../../messages/services/chat.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
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
    private estadoService: EstadoService,
    private chatService: ChatService,
    private router: Router
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

  contactMessage(target: number | any): void {
    // For projects, always message the company (empresa). If only summary available, load full project to get empresa.id
    const handleChat = (companyId?: number) => {
      if (!companyId) {
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'No se pudo iniciar el chat: compañía destino no disponible.',
        });
        return;
      }
      this.chatService.createPrivateChat(companyId).subscribe({
        next: (chatRoom: any) => {
          this.router.navigate(['/messages', chatRoom.id]);
        },
        error: (err: any) => {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: err?.error?.message || 'No se pudo iniciar el chat con la compañía.',
          });
        },
      });
    };

    if (typeof target === 'number') {
      // explicit id provided
      handleChat(target as number);
      return;
    }

    if (target) {
      // try direct company field
      const companyId = target.empresa?.id || target.propuesta?.necesidad?.companiaId || target.propuesta?.necesidad?.compania?.id;
      if (companyId) {
        handleChat(companyId);
        return;
      }

      if (target.id) {
        // load full project
        this.proyectoService.getById(target.id).subscribe({
          next: (proj: any) => {
            handleChat(proj.empresa?.id);
          },
          error: () => {
            Swal.fire({
              icon: 'error',
              title: 'Error',
              text: 'No se pudo cargar los detalles del proyecto.',
            });
          },
        });
        return;
      }
    }

    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'No se pudo iniciar el chat: compañía destino no disponible.',
    });
  }

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
