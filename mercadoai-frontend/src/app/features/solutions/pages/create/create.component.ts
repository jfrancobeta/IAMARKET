import { Component, OnInit } from '@angular/core';
import { Route, Router, RouterLink } from '@angular/router';
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
import { MainLayoutComponent } from "../../../../shared/layout/main-layout/main-layout.component";
import { routes } from '../../../../app.routes';

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
    tiempoEntrega: 0,
    unidadEntrega: UnidadEntrega.Dias,
    desarrolladorId: 0, 
  };

  featureInput: string = '';
  requirementInput: string = '';

  UnidadEntrega = UnidadEntrega;

  skills: HabilidadDTO[] = [];

  categories: CategoriaDTO[] = [];

  constructor(
    private solucionService: SolutionService,
    private skillsService: HabilidadService,
    private categoryService: CategoriaService,
    private routes: Router
  ) {}

  ngOnInit(): void {
    this.loadSkills();
    this.loadCategories();
  }

  onSubmit(): void {
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
}
