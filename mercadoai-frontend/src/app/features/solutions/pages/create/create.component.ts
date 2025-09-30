import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router, RouterLink } from '@angular/router';
import { CategoriaDTO } from '../../../../core/models/Categoria/CategoriaDTO';
import { EstadoDTO } from '../../../../core/models/Estado/EstadoDTO';
import {
  SolucionDetailsDTO,
  UnidadEntrega,
} from '../../../../core/models/Solucion/SolucionDetailsDTO';
import { UsuarioDTO } from '../../../../core/models/Usuario/UsuarioDTO';
import { SolutionService } from '../../services/solution.service';
import { HabilidadService } from '../../../../core/services/habilidad.service';
import { HabilidadDTO } from '../../../../core/models/Habilidad/HabilidadDTO';
import { CategoriaService } from '../../../../core/services/categoria.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { SolucionCreateDTO } from '../../../../core/models/Solucion/SolutionCreateDTO';
import Swal from 'sweetalert2';
import { MainLayoutComponent } from '../../../../shared/layout/main-layout/main-layout.component';
import { routes } from '../../../../app.routes';
import { SolucionUpdateDTO } from '../../../../core/models/Solucion/SolucionUpdateDTO';
import { HitoCreateDTO } from '../../../../core/models/Hito/HitoCreateDTO';

@Component({
  selector: 'app-create',
  standalone: true,
  imports: [RouterLink, FormsModule, CommonModule, MainLayoutComponent],
  templateUrl: './create.component.html',
})
export class CreateComponent implements OnInit {
  SolucionDTO: SolucionCreateDTO = {
    titulo: '',
    descripcion: '',
    precio: 0,
    categoriaId: 0,
    estadoId: 0,
    habilidadesIds: [],
    caracteristicas: [],
    requisitos: [],
    hitos: [],
    tiempoEntrega: 0,
    unidadEntrega: UnidadEntrega.Dias,
    desarrolladorId: 0,
  };

  nuevoHito: HitoCreateDTO = {
      nombre: '',
      descripcion: '',
      fechaEntrega: '',
      entregables: []
  };

  featureInput: string = '';
  requirementInput: string = '';

  UnidadEntrega = UnidadEntrega;

  skills: HabilidadDTO[] = [];

  categories: CategoriaDTO[] = [];

  idSolution: number | null = null;

  constructor(
    private solucionService: SolutionService,
    private skillsService: HabilidadService,
    private categoryService: CategoriaService,
    private router: ActivatedRoute,
    private routes: Router
  ) {}

  ngOnInit(): void {
    this.loadSkills();
    this.loadCategories();
    this.idSolution = Number(this.router.snapshot.paramMap.get('id'));
    if (this.idSolution) {
      this.loadSolution();
    }
  }

  loadSolution(): void {
    this.solucionService.getById(this.idSolution!).subscribe({
      next: (data) => {
        this.SolucionDTO = {
          titulo: data.titulo,
          descripcion: data.descripcion,
          precio: data.precio,
          categoriaId: data.categoria.id,
          estadoId: data.estado.id || 0,
          habilidadesIds: Array.isArray(data.habilidades)
            ? data.habilidades.map((h: any) => h.id)
            : [],
          caracteristicas: data.caracteristicas || [],
          requisitos: data.requisitos || [],
          hitos: data.hitos || [],
          tiempoEntrega: data.tiempoEntrega,
          unidadEntrega: data.unidadEntrega,
          desarrolladorId: data.desarrollador.id || 0,
        };
      },
    });
  }
  onSubmit(): void {
    if (this.idSolution) {
      const updateData: SolucionUpdateDTO = {
        ...this.SolucionDTO,
        hitos: this.SolucionDTO.hitos.map((hito: any) => ({
          ...hito,
          id: hito.id,
        })),
      };
      console.log('updateData', updateData);
      this.solucionService.update(this.idSolution, updateData).subscribe({
        next: (response) => {
          this.routes.navigate(['/solutions']);
          Swal.fire({
            icon: 'success',
            title: '¡Éxito!',
            text: 'La solución se ha actualizado correctamente.',
          });
        },
        error: (err) => {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Hubo un problema al actualizar la solución. Por favor, inténtalo de nuevo.',
          });
        },
      });
    } else {
      this.solucionService.create(this.SolucionDTO).subscribe({
        next: (response) => {
          this.routes.navigate(['/solutions']);
          Swal.fire({
            icon: 'success',
            title: '¡Éxito!',
            text: 'La solución se ha creado correctamente.',
          });
        },
        error: (err) => {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Hubo un problema al crear la solución. Por favor, inténtalo de nuevo.',
          });
        },
      });
    }
  }

  loadSkills(): void {
    this.skillsService.getAll().subscribe({
      next: (skills) => {
        this.skills = skills;
      },
      error: (err) => {
        console.error('Failed to load skills:', err);
      },
    });
  }

  loadCategories(): void {
    this.categoryService.getAll().subscribe({
      next: (categories) => {
        this.categories = categories;
      },
      error: (err) => {
        console.error('Failed to load categories:', err);
      },
    });
  }

  addFeature() {
    const value = this.featureInput.trim();
    if (value) {
      this.SolucionDTO.caracteristicas.push(value);
      this.featureInput = '';
    }
  }

  removeFeature(index: number) {
    this.SolucionDTO.caracteristicas.splice(index, 1);
  }

  addRequirement() {
    const value = this.requirementInput.trim();
    if (value) {
      this.SolucionDTO.requisitos.push(value);
      this.requirementInput = '';
    }
  }

  removeRequirement(index: number) {
    this.SolucionDTO.requisitos.splice(index, 1);
  }

  onSkillToggle(id: number, event: any) {
    if (event.target.checked) {
      if (!this.SolucionDTO.habilidadesIds.includes(id)) {
        this.SolucionDTO.habilidadesIds.push(id);
      }
    } else {
      this.SolucionDTO.habilidadesIds = this.SolucionDTO.habilidadesIds.filter(
        (habId) => habId !== id
      );
    }
  }

  agregarHito() {
    this.SolucionDTO.hitos.push({
      ...this.nuevoHito,
    });
    this.nuevoHito = {
      nombre: '',
      descripcion: '',
      fechaEntrega: '',
      entregables: [],
    };
  }

  eliminarHito(index: number) {
    this.SolucionDTO.hitos.splice(index, 1);
  }
  agregarEntregableAHito(hitoIndex: number) {
    this.SolucionDTO.hitos[hitoIndex].entregables.push({ nombreArchivo: '' });
}

eliminarEntregableDeHito(hitoIndex: number, entregableIndex: number) {
  this.SolucionDTO.hitos[hitoIndex].entregables.splice(entregableIndex, 1);
}
}
