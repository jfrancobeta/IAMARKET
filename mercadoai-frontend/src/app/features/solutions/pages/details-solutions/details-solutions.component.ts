import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { MainLayoutComponent } from '../../../../shared/layout/main-layout/main-layout.component';
import { SolucionDTO } from '../../../../core/models/Solucion/SolucionDTO';
import { SolutionService } from '../../services/solution.service';
import Swal from 'sweetalert2';
import {
  SolucionDetailsDTO,
  UnidadEntrega,
} from '../../../../core/models/Solucion/SolucionDetailsDTO';
import { CategoriaDTO } from '../../../../core/models/Categoria/CategoriaDTO';
import { EstadoDTO } from '../../../../core/models/Estado/EstadoDTO';
import { UsuarioDTO } from '../../../../core/models/Usuario/UsuarioDTO';
import { DatePipe, DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-details-solutions',
  standalone: true,
  imports: [MainLayoutComponent, RouterModule, DatePipe, DecimalPipe],
  templateUrl: './details-solutions.component.html',
})
export class DetailsSolutionsComponent implements OnInit {
  SolucionDTO: SolucionDetailsDTO = {
    id: 0,
    titulo: '',
    descripcion: '',
    precio: 0,
    vistas: 0,
    pedidos: 0,
    categoria: {} as CategoriaDTO,
    estado: {} as EstadoDTO,
    habilidades: [],
    caracteristicas: [],
    requisitos: [],
    tiempoEntrega: 0,
    unidadEntrega: UnidadEntrega.Dias, 
    fechaCreacion: '',
    fechaActualizacion: '',
    desarrollador: {} as UsuarioDTO,
  };
  constructor(
    private solucionService: SolutionService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.loadSolucion();
  }

  private loadSolucion(): void {
    const solucionId = this.route.snapshot.paramMap.get('id');
    if (solucionId) {
      this.solucionService.getById(+solucionId).subscribe({
        next: (solucion) => {
          console.log('Loaded solution:', solucion);
          this.SolucionDTO = solucion;
        },
        error: (err) => {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'No se pudo cargar la solución. Por favor, inténtelo de nuevo más tarde.',
          });
          console.error('Error loading solution:', err);
        },
      });
    }
  }
}
