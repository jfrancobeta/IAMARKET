import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterModule, Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';
import { CategoriaDTO } from '../../../../core/models/Categoria/CategoriaDTO';
import { HabilidadDTO } from '../../../../core/models/Habilidad/HabilidadDTO';
import { NecesidadCreateDTO } from '../../../../core/models/Necesidad/NecesidadCreateDTO';
import { CategoriaService } from '../../../../core/services/categoria.service';
import { HabilidadService } from '../../../../core/services/habilidad.service';
import { MainLayoutComponent } from '../../../../shared/layout/main-layout/main-layout.component';
import { NeedService } from '../../services/need.service';
import { HitoCreateDTO } from '../../../../core/models/Hito/HitoCreateDTO';

@Component({
  selector: 'app-create',
  standalone: true,
  imports: [MainLayoutComponent, RouterModule, FormsModule, CommonModule],
  templateUrl: './create.component.html',
})
export class CreateComponent implements OnInit {
  need: NecesidadCreateDTO = {
    titulo: '',
    descripcion: '',
    categoria: 0,
    presupuesto: 0,
    companiaId: 0,
    fechaLimite: '',
    skillsRequiredIds: [],
    requirements: [],
    hitos: [],
    estadoId: 0,
  };

  nuevoHito: HitoCreateDTO = {
    nombre: '',
    descripcion: '',
    fechaEntrega: '',
    entregables: []
  };

  habilidades: HabilidadDTO[] = [];

  nuevoEntregable: string = '';

  nuevoRequerimiento: string = '';

  categorias: CategoriaDTO[] = [];

  idNeed: String | null = null;

  constructor(
    private needService: NeedService,
    private habilidadService: HabilidadService,
    private categoriaService: CategoriaService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.categoriaService.getAll().subscribe({
      next: (response) => {
        this.categorias = response;
      },
      error: (error) => {
        console.error('Error al cargar categorías:', error);
      },
    });

    this.habilidadService.getAll().subscribe({
      next: (response) => {
        this.habilidades = response;
      },
      error: (error) => {
        console.error('Error al cargar habilidades:', error);
      },
    });

    this.idNeed = this.route.snapshot.paramMap.get('id');
    if (this.idNeed) {
      this.needService.getById(+this.idNeed).subscribe({
        next: (data) => {
          this.need = {
            titulo: data.titulo,
            descripcion: data.descripcion,
            categoria: Number(data.categoria.id) ?? 0,
            presupuesto: data.presupuesto,
            companiaId: data.compania?.id ?? 0,
            fechaLimite: data.fechaLimite,
            skillsRequiredIds: data.skillsRequired?.map((s: any) => s.id) ?? [],
            requirements: data.requirements ?? [],
            hitos: data.hitos ?? [],
            estadoId: data.estado.id ?? 0, // Ajusta según tu modelo
          };
        },
        error: (error) => {
          console.error('Error al cargar la necesidad:', error);
        },
      });
    }
  }

  onSubmit(form: NgForm) {
    if (form.invalid) {
      return;
    }
    if (this.idNeed) {
      // Editar
      this.needService.update(+this.idNeed, this.need).subscribe({
        next: (response) => {
          Swal.fire({
            title: 'Éxito',
            text: 'La necesidad ha sido actualizada exitosamente.',
            icon: 'success',
            confirmButtonText: 'Aceptar',
          });
          this.router.navigate(['/needs']);
        },
        error: (error) => {
          console.error('Error al actualizar necesidad:', error);
        },
      });
    } else {
      this.needService.create(this.need).subscribe({
        next: (response) => {
          console.log('Necesidad creada:', response);
          Swal.fire({
            title: 'Éxito',
            text: 'La necesidad ha sido creada exitosamente.',
            icon: 'success',
            confirmButtonText: 'Aceptar',
          });
          this.router.navigate(['/needs']);
        },
        error: (error) => {
          console.error('Error al crear necesidad:', error);
        },
      });
    }
  }
  agregarRequeriment() {
    if (this.nuevoRequerimiento.trim()) {
      if (!this.need.requirements) {
        this.need.requirements = [];
      }
      this.need.requirements.push(this.nuevoRequerimiento.trim());
      this.nuevoRequerimiento = '';
    }
  }

  eliminarRequeriment(index: number) {
    if (this.need.requirements) {
      this.need.requirements.splice(index, 1);
    }
  }

  onHabilidadChange(event: any, id: number) {
    if (event.target.checked) {
      if (!this.need.skillsRequiredIds.includes(id)) {
        this.need.skillsRequiredIds.push(id);
      }
    } else {
      this.need.skillsRequiredIds = this.need.skillsRequiredIds.filter(
        (habId) => habId !== id
      );
    }
  }
  agregarHito() {
    this.need.hitos.push({
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
    this.need.hitos.splice(index, 1);
  }

  agregarEntregableAHito(hitoIndex: number) {
  this.need.hitos[hitoIndex].entregables.push({ nombreArchivo: '' });
  }

  eliminarEntregableDeHito(hitoIndex: number, entregableIndex: number) {
    this.need.hitos[hitoIndex].entregables.splice(entregableIndex, 1);
  }
}
