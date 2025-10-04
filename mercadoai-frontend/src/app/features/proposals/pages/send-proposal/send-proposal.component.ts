import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../../shared/layout/main-layout/main-layout.component';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { NecesidadDTO } from '../../../../core/models/Necesidad/NecesidadDTO';
import { FormsModule } from '@angular/forms';
import { PropuestaCreateDTO } from '../../../../core/models/Propuesta/PropuestaCreateDTO';
import { CommonModule } from '@angular/common';
import { NeedService } from '../../../needs/services/need.service';
import { PropuestaService } from '../../services/propuesta.service';
import Swal from 'sweetalert2';
import { PropuestaDTO } from '../../../../core/models/Propuesta/PropuestaDTO';
import { PropuestaUpdateDTO } from '../../../../core/models/Propuesta/PropuestaUpdateDTO';

@Component({
  selector: 'app-send-proposal',
  standalone: true,
  imports: [MainLayoutComponent, RouterLink, FormsModule, CommonModule],
  templateUrl: './send-proposal.component.html',
})
export class SendProposalComponent implements OnInit {
  necesidad?: NecesidadDTO;
  propuestaExistente?: PropuestaDTO;

  propuesta: PropuestaCreateDTO = {
    necesidadId: 0,
    precio: 0,
    entrega: '',
    descripcion: '',
    hitos: [],
  };

  isEditMode = false;
  propuestaId?: number;

  constructor(
    private necesidadService: NeedService,
    private propuestaService: PropuestaService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const url = this.router.url;

    if (url.includes('/proposals/') && url.includes('/edit')) {
      // Modo edición: el id es de la propuesta
      this.propuestaId = Number(this.route.snapshot.params['id']);
      this.isEditMode = true;
      this.loadPropuestaForEdit(this.propuestaId);
    } else {
      // Modo creación: el id es de la necesidad
      const necesidadId = Number(this.route.snapshot.params['id']);
      this.isEditMode = false;
      this.loadNecesidadForCreate(necesidadId);
    }
  }

  loadNecesidadForCreate(id: number): void {
    this.necesidadService.getById(id).subscribe({
      next: (data) => {
        this.necesidad = data;
        this.propuesta.necesidadId = data.id ?? 0;
        // Prellenar con datos de la necesidad como sugerencia
        this.propuesta.precio = data.presupuesto;
        this.propuesta.entrega = data.fechaLimite;
        this.propuesta.descripcion = data.descripcion;
        this.propuesta.hitos = data.hitos || [];
      },
      error: (error) => {
        console.error('Error loading necesidad:', error);
        this.router.navigate(['/needs']);
      },
    });
  }
  loadPropuestaForEdit(id: number): void {
    this.propuestaService.getById(id).subscribe({
      next: (data) => {
        console.log('Propuesta cargada para edición:', data);
        this.propuestaExistente = data;
        // Cargar también la necesidad relacionada
        this.necesidadService.getById(data.necesidad.id ?? 0).subscribe({
          next: (necesidad) => {
            this.necesidad = necesidad;
          },
        });

        // Mapear datos de la propuesta existente al formulario
        this.propuesta = {
          necesidadId: data.necesidad.id ?? 0,
          precio: data.precio,
          entrega: data.entrega,
          descripcion: data.descripcion,
          hitos: data.hitos || [],
        };
      },
      error: (error) => {
        console.error('Error loading propuesta:', error);
        this.router.navigate(['/proposals']);
      },
    });
  }
  onSubmit(): void {
    if (this.isEditMode) {
      this.updatePropuesta();
    } else {
      this.createPropuesta();
    }
  }

  createPropuesta(): void {
    this.propuestaService.create(this.propuesta).subscribe({
      next: (response) => {
        Swal.fire({
          icon: 'success',
          title: 'Propuesta enviada',
          text: 'Tu propuesta ha sido enviada con éxito.',
        });
        this.router.navigate(['/proposals']);
      },
      error: (error) => {
        console.error('Error creating propuesta:', error);
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'Hubo un problema al enviar tu propuesta.',
        });
      },
    });
  }
  updatePropuesta(): void {
    const updateDTO: PropuestaUpdateDTO = {
      precio: this.propuesta.precio,
      entrega: this.propuesta.entrega,
      descripcion: this.propuesta.descripcion,
      hitos: this.propuesta.hitos,
    };

    this.propuestaService.update(this.propuestaId!, updateDTO).subscribe({
      next: (response) => {
        Swal.fire({
          icon: 'success',
          title: 'Propuesta actualizada',
          text: 'Tu propuesta ha sido actualizada con éxito.',
        });
        this.router.navigate(['/proposals', this.propuestaId]);
      },
      error: (error) => {
        console.error('Error updating propuesta:', error);
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'Hubo un problema al actualizar tu propuesta.',
        });
      },
    });
  }
  addMilestone(): void {
    this.propuesta.hitos.push({
      nombre: '',
      descripcion: '',
      fechaEntrega: '',
      entregables: [{ nombreArchivo: '' }],
    });
  }

  addDeliverable(hitoIndex: number): void {
    this.propuesta.hitos[hitoIndex].entregables.push({ nombreArchivo: '' });
  }

  removeDeliverable(hitoIndex: number, entregableIndex: number): void {
    this.propuesta.hitos[hitoIndex].entregables.splice(entregableIndex, 1);
  }
}
