import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../../shared/layout/main-layout/main-layout.component';
import { ActivatedRoute, RouterLink, RouterModule } from '@angular/router';
import { ProyectoService } from '../../services/proyecto.service';
import { ProyectoDTO } from '../../../../core/models/Proyecto/ProyectoDTO';
import { AuthService } from '../../../../core/services/auth.service';
import { CommonModule } from '@angular/common';
import { EntregableService } from '../../services/entregable.service';
import Swal from 'sweetalert2';
import { HitoCreateDTO } from '../../../../core/models/Hito/HitoCreateDTO';
import { FormsModule } from '@angular/forms';
import { HitoUpdateDTO } from '../../../../core/models/Hito/HitoUpdateDTO';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [MainLayoutComponent, RouterModule, CommonModule, FormsModule],
  templateUrl: './details.component.html',
})
export class DetailsComponent implements OnInit {
  proyecto!: ProyectoDTO;
  userType!: any[];
  selectedEntregableId: number | null = null;
  selectedFile: File | null = null;
  uploading = false;
  selectedEntregableIdToAccept: number | null = null;
  selectedEntregableIdToReject: number | null = null;
  modoHito: 'crear' | 'editar' = 'crear';
  hitoEditIndex: number | null = null;
  agregandoHito = false;

  nuevoHito = {
    id: null,
    nombre: '',
    descripcion: '',
    fechaEntrega: '',
    entregables: [] as { nombreArchivo: string }[],
  };
  nuevoEntregableNombre = '';

  constructor(
    private proyectoService: ProyectoService,
    private authService: AuthService,
    private route: ActivatedRoute,
    private entregableService: EntregableService
  ) {}

  ngOnInit(): void {
    this.loadProjectDetails(this.route.snapshot.params['id']);
    this.userType = this.authService.getRoles();
    console.log(this.userType);
  }

  loadProjectDetails(id: number) {
    this.proyectoService.getById(id).subscribe((data) => {
      this.proyecto = data;
      console.log(this.proyecto);
    });
  }

  get isDeveloper(): boolean {
    return this.userType?.includes('ROLE_DEVELOPER');
  }

  get isCompany(): boolean {
    return this.userType?.includes('ROLE_COMPANY');
  }

  openUploadModal(entregableId: number) {
    this.selectedEntregableId = entregableId;
    this.selectedFile = null;
  }
  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0] || null;
  }

  uploadFile() {
    if (!this.selectedEntregableId || !this.selectedFile) return;
    this.uploading = true;
    this.entregableService
      .uploadEntregable(this.selectedEntregableId, this.selectedFile)
      .subscribe({
        next: (res) => {
          this.uploading = false;
          // Opcional: recargar los datos del proyecto o actualizar el entregable en la UI
          this.loadProjectDetails(this.proyecto.id);
          // Cierra el modal con JS puro o Bootstrap
          (window as any).bootstrap.Modal.getOrCreateInstance(
            document.getElementById('uploadModal')
          ).hide();
        },
        error: (err) => {
          this.uploading = false;
          alert('Error al subir el archivo');
        },
      });
  }

  aprobarEntregable() {
    if (!this.selectedEntregableIdToAccept) return;
    this.entregableService
      .aprobarEntregable(this.selectedEntregableIdToAccept)
      .subscribe({
        next: (res) => {
          this.loadProjectDetails(this.proyecto.id);
          (window as any).bootstrap.Modal.getOrCreateInstance(
            document.getElementById('acceptModal')
          ).hide();
        },
        error: (err) => {
          Swal.fire({
            icon: 'error',
            title: 'No se pudo aprobar el entregable.',
          });
        },
      });
  }

  descargarArchivo(entregableId: number, nombreArchivo: string) {
    this.entregableService.downloadEntregable(entregableId).subscribe({
      next: (response: any) => {
        console.log('response', response.headers);
        let blob: Blob;
        let filename = nombreArchivo;

        // Si usas observe: 'response' en el servicio, puedes obtener headers
        if (response.body && response.headers) {
          blob = response.body;
          const contentDisposition = response.headers.get(
            'content-disposition'
          );
          console.log('content-disposition:', contentDisposition);
          const match =
            contentDisposition && contentDisposition.match(/filename="(.+)"/);
          console.log('match:', match);
          if (match) {
            filename = match[1];
          }
        } else {
          blob = response;
        }
        console.log(blob);
        console.log(filename);
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = filename;
        a.click();
        window.URL.revokeObjectURL(url);
      },
      error: (err) => {
        Swal.fire({
          icon: 'error',
          title: 'No se pudo descargar el archivo.',
          toast: true,
          position: 'top-end',
          showConfirmButton: false,
          timer: 3000,
          timerProgressBar: true,
        });
      },
    });
  }

  rechazarEntregable() {
    if (!this.selectedEntregableIdToReject) return;
    this.entregableService
      .rechazarEntregable(this.selectedEntregableIdToReject)
      .subscribe({
        next: () => {
          this.loadProjectDetails(this.proyecto.id);
          (window as any).bootstrap.Modal.getOrCreateInstance(
            document.getElementById('rejectModal')
          ).hide();
        },
        error: () => {
          alert('Error al rechazar el entregable');
        },
      });
  }

  openAcceptModal(entregableId: number) {
    this.selectedEntregableIdToAccept = entregableId;
  }

  openRejectModal(entregableId: number) {
    this.selectedEntregableIdToReject = entregableId;
  }

  agregarEntregable() {
    if (this.nuevoEntregableNombre.trim()) {
      this.nuevoHito.entregables.push({
        nombreArchivo: this.nuevoEntregableNombre.trim(),
      });
      this.nuevoEntregableNombre = '';
    }
  }

  // Quitar un entregable del nuevo hito
  quitarEntregable(index: number) {
    this.nuevoHito.entregables.splice(index, 1);
  }

  // Guardar el nuevo hito
  guardarHito() {
    if (!this.nuevoHito.nombre || !this.nuevoHito.fechaEntrega) return;
    this.agregandoHito = true;

    if (this.modoHito === 'crear') {
      const hitoCreate: HitoCreateDTO = {
        nombre: this.nuevoHito.nombre,
        descripcion: this.nuevoHito.descripcion,
        fechaEntrega: this.nuevoHito.fechaEntrega,
        entregables: this.nuevoHito.entregables,
      };
      this.proyectoService.addHito(this.proyecto.id, hitoCreate).subscribe({
        next: () => {
          this.loadProjectDetails(this.proyecto.id);
          this.cerrarModalHito();
        },
        error: () => {
          this.agregandoHito = false;
          Swal.fire({
            icon: 'error',
            title: 'No se pudo agregar el hito.',
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
          });
        },
      });
    } else if (this.modoHito === 'editar' && this.nuevoHito.id) {
      const hitoUpdate: HitoUpdateDTO = {
        id: this.nuevoHito.id!,
        nombre: this.nuevoHito.nombre,
        descripcion: this.nuevoHito.descripcion,
        fechaEntrega: this.nuevoHito.fechaEntrega,
        entregables: this.nuevoHito.entregables,
      };
      this.proyectoService
        .editarHito(this.proyecto.id, this.nuevoHito.id, hitoUpdate)
        .subscribe({
          next: () => {
            this.loadProjectDetails(this.proyecto.id);
            this.cerrarModalHito();
          },
          error: () => {
            this.agregandoHito = false;
            Swal.fire({
              icon: 'error',
              title: 'No se pudo editar el hito.',
              toast: true,
              position: 'top-end',
              showConfirmButton: false,
              timer: 3000,
              timerProgressBar: true,
            });
          },
        });
    }
  }

  cerrarModalHito() {
    this.agregandoHito = false;
    (window as any).bootstrap.Modal.getOrCreateInstance(
      document.getElementById('addMilestoneModal')
    ).hide();
    this.nuevoHito = {
      id: null,
      nombre: '',
      descripcion: '',
      fechaEntrega: '',
      entregables: [],
    };
    this.nuevoEntregableNombre = '';
    this.hitoEditIndex = null;
  }

  openAddHitoModal() {
    this.modoHito = 'crear';
    this.hitoEditIndex = null;
    this.nuevoHito = {
      id: null,
      nombre: '',
      descripcion: '',
      fechaEntrega: '',
      entregables: [],
    };
    this.nuevoEntregableNombre = '';
  }

  openEditHitoModal(hito: any, index: number) {
    this.modoHito = 'editar';
    this.hitoEditIndex = index;
    this.nuevoHito = {
      id: hito.id,
      nombre: hito.nombre,
      descripcion: hito.descripcion,
      fechaEntrega: hito.fechaEntrega,
      entregables: hito.entregables.map((e: any) => ({ ...e })),
    };
    this.nuevoEntregableNombre = '';
    // Abre el modal si no usas data-bs-toggle
    (window as any).bootstrap.Modal.getOrCreateInstance(
      document.getElementById('addMilestoneModal')
    ).show();
  }
}
