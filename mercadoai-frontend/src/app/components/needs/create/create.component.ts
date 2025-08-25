import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from "../../layout/main-layout/main-layout.component";
import { Router, RouterModule } from '@angular/router';
import { NecesidadCreateDTO } from '../../../models/Necesidad/NecesidadCreateDTO';
import { NeedService } from '../../../services/need.service';
import { FormsModule, NgForm } from '@angular/forms';
import { HabilidadDTO } from '../../../models/Habilidad/HabilidadDTO';
import { HabilidadService } from '../../../services/habilidad.service';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create',
  standalone: true,
  imports: [MainLayoutComponent,RouterModule,FormsModule,CommonModule],
  templateUrl: './create.component.html',
})
export class CreateComponent implements OnInit {

  need: NecesidadCreateDTO = {
    titulo: '',
    descripcion: '',
    categoria: '',
    presupuesto: 0,
    companiaId: 0,
    fechaLimite: '',
    skillsRequiredIds: [],
    requirements: [],
    expectedDeliverables: [],
    estadoId: 0
  };

  habilidades: HabilidadDTO[] = [];

  nuevoEntregable: string = '';

  nuevoRequerimiento: string = '';

  constructor(private needService: NeedService,
    private habilidadService: HabilidadService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.habilidadService.getAll().subscribe({
      next: (response) => {
        this.habilidades = response;
      },
      error: (error) => {
        console.error('Error al cargar habilidades:', error);
      }
    });
  }

  onSubmit(form: NgForm){
    if(form.invalid){
      return;
    }
    this.needService.create(this.need).subscribe({
      next: (response) => {
        console.log('Necesidad creada:', response);
        Swal.fire({
          title: 'Éxito',
          text: 'La necesidad ha sido creada exitosamente.',
          icon: 'success',
          confirmButtonText: 'Aceptar'
        });
        this.router.navigate(['/needs']);

      },
      error: (error) => {
        console.error('Error al crear necesidad:', error);
      }
    });
  }

  agregarEntregable() {
    if (this.nuevoEntregable.trim()) {
      if (!this.need.expectedDeliverables) {
        this.need.expectedDeliverables = [];
      }
      this.need.expectedDeliverables.push(this.nuevoEntregable.trim());
      this.nuevoEntregable = '';
    }
  }

  eliminarEntregable(index: number) {
    if (this.need.expectedDeliverables) {
      this.need.expectedDeliverables.splice(index, 1);
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
    this.need.skillsRequiredIds = this.need.skillsRequiredIds.filter(habId => habId !== id);
  }
}
}
