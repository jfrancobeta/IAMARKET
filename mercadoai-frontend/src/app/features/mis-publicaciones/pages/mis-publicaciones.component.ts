import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NecesidadSummaryDTO } from '../../../core/models/Necesidad/NecesidadSummaryDTO';
import { SolucionSummaryDTO } from '../../../core/models/Solucion/SolucionSummaryDTO';
import { NeedService } from '../../needs/services/need.service';
import { SolutionService } from '../../solutions/services/solution.service';
import { AuthService } from '../../../core/services/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-mis-publicaciones',
  standalone: true,
  imports: [CommonModule, MainLayoutComponent, RouterModule, FormsModule],
  templateUrl: './mis-publicaciones.component.html',
})
export class MisPublicacionesComponent implements OnInit {
  necesidades: NecesidadSummaryDTO[] = [];
  soluciones: SolucionSummaryDTO[] = [];
  activeTab: 'necesidades' | 'soluciones' = 'necesidades';
  currentUserId: number | null = null;

  necesidadesPaginacion = {
    page: 0,
    size: 10,
    totalPages: 0,
  };

  solucionesPaginacion = {
    page: 0,
    size: 10,
    totalPages: 0,
  };

  constructor(
    private needService: NeedService,
    private solutionService: SolutionService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.currentUserId = this.authService.user.usuario;
    this.loadMisNecesidades();
  }

  setTab(tab: 'necesidades' | 'soluciones'): void {
    this.activeTab = tab;
    if (tab === 'necesidades') {
      this.loadMisNecesidades();
    } else {
      this.loadMisSoluciones();
    }
  }

  loadMisNecesidades(): void {
    const params = {
      page: this.necesidadesPaginacion.page,
      size: this.necesidadesPaginacion.size,
    };
    this.needService.getMis(params).subscribe((page) => {
      this.necesidades = page.content;
      this.necesidadesPaginacion.totalPages = page.totalPages;
    });
  }

  loadMisSoluciones(): void {
    const params = {
      page: this.solucionesPaginacion.page,
      size: this.solucionesPaginacion.size,
    };
    this.solutionService.getMis(params).subscribe((page) => {
      this.soluciones = page.content;
      this.solucionesPaginacion.totalPages = page.totalPages;
    });
  }

  changeNecesidadesPage(page: number): void {
    if (page >= 0 && page < this.necesidadesPaginacion.totalPages) {
      this.necesidadesPaginacion.page = page;
      this.loadMisNecesidades();
    }
  }

  changeSolucionesPage(page: number): void {
    if (page >= 0 && page < this.solucionesPaginacion.totalPages) {
      this.solucionesPaginacion.page = page;
      this.loadMisSoluciones();
    }
  }

  deleteNecesidad(id: number): void {
    Swal.fire({
      title: '¿Eliminar necesidad?',
      text: 'Esta acción no se puede deshacer',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Eliminar',
      cancelButtonText: 'Cancelar',
      confirmButtonColor: '#dc3545',
    }).then((result) => {
      if (result.isConfirmed) {
        this.needService.delete(id).subscribe({
          next: () => {
            Swal.fire('Eliminado', 'La necesidad ha sido eliminada', 'success');
            this.necesidadesPaginacion.page = 0;
            this.loadMisNecesidades();
          },
          error: (err: any) => {
            console.error('Error eliminando necesidad:', err);
            Swal.fire('Error', err?.error?.message || 'No se pudo eliminar la necesidad', 'error');
          },
        });
      }
    });
  }

  deleteSolucion(id: number): void {
    Swal.fire({
      title: '¿Eliminar solución?',
      text: 'Esta acción no se puede deshacer',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Eliminar',
      cancelButtonText: 'Cancelar',
      confirmButtonColor: '#dc3545',
    }).then((result) => {
      if (result.isConfirmed) {
        this.solutionService.delete(id).subscribe({
          next: () => {
            Swal.fire('Eliminado', 'La solución ha sido eliminada', 'success');
            this.solucionesPaginacion.page = 0;
            this.loadMisSoluciones();
          },
          error: (err: any) => {
            console.error('Error eliminando solución:', err);
            Swal.fire('Error', err?.error?.message || 'No se pudo eliminar la solución', 'error');
          },
        });
      }
    });
  }
}
