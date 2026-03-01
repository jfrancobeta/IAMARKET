import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../../shared/layout/main-layout/main-layout.component';
import { ChatService } from '../../../messages/services/chat.service';
import { Router } from '@angular/router';
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
import { CancelRequestDTO } from '../../../../core/models/CancelRequest/CancelRequestDTO';

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
  cancelReason: string = '';
  selectedCancelRequest: CancelRequestDTO | null = null;
  approveComments: string = '';
  rejectComments: string = '';
  processingCancel = false;

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
    private entregableService: EntregableService,
    private chatService: ChatService,
    private ngRouter: Router
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

  contactMessage(target: number | any): void {
    // For project details, message the company (empresa)
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
          this.ngRouter.navigate(['/messages', chatRoom.id]);
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
      handleChat(target as number);
      return;
    }

    const companyId = target?.empresa?.id || this.proyecto?.empresa?.id;
    if (companyId) {
      handleChat(companyId);
      return;
    }

    if (target && target.id) {
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

    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'No se pudo iniciar el chat: compañía destino no disponible.',
    });
  }

  contactClient(): void {
    const companyId = this.proyecto?.empresa?.id;
    if (!companyId) {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'ID de la compañía no disponible.',
      });
      return;
    }
    this.chatService.createPrivateChat(companyId).subscribe({
      next: (chatRoom: any) => this.ngRouter.navigate(['/messages', chatRoom.id]),
      error: (err: any) => Swal.fire({ icon: 'error', title: 'Error', text: err?.error?.message || 'No se pudo contactar a la compañía.' }),
    });
  }

  contactDeveloper(): void {
    const developerId = this.proyecto?.desarrollador?.id;
    if (!developerId) {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'ID del desarrollador no disponible.',
      });
      return;
    }
    this.chatService.createPrivateChat(developerId).subscribe({
      next: (chatRoom: any) => this.ngRouter.navigate(['/messages', chatRoom.id]),
      error: (err: any) => Swal.fire({ icon: 'error', title: 'Error', text: err?.error?.message || 'No se pudo contactar al desarrollador.' }),
    });
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

  confirmDeleteHito(hito: any, index: number) {
    Swal.fire({
      title: '¿Eliminar hito?',
      text: 'Esta acción no se puede deshacer.',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, eliminar',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        this.proyectoService.deleteHito(this.proyecto.id, hito.id).subscribe({
          next: () => {
            Swal.fire({
              icon: 'success',
              title: 'Hito eliminado',
              toast: true,
              position: 'top-end',
              showConfirmButton: false,
              timer: 2000,
            });
            this.loadProjectDetails(this.proyecto.id);
          },
          error: () => {
            Swal.fire({
              icon: 'error',
              title: 'No se pudo eliminar el hito.',
            });
          },
        });
      }
    });
  }

  requestCancelation() {
    if (this.hasPendingCancelRequest) {
      Swal.fire({
        icon: 'warning',
        title: 'Ya existe una solicitud de cancelación pendiente.',
        text: 'Espera a que la otra parte responda antes de enviar una nueva solicitud.',
      });
      return;
    }

    if (!this.cancelReason.trim()) {
      Swal.fire({
        icon: 'warning',
        title: 'Debe ingresar una razón para la cancelación.',
      });
      return;
    }

    this.processingCancel = true;
    this.proyectoService
      .requestCancel(this.proyecto.id, this.cancelReason)
      .subscribe({
        next: () => {
          this.processingCancel = false;
          Swal.fire({
            icon: 'success',
            title: 'Solicitud de cancelación enviada.',
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
          });
          this.loadProjectDetails(this.proyecto.id);
          (window as any).bootstrap.Modal.getOrCreateInstance(
            document.getElementById('cancelModal')
          ).hide();
          this.cancelReason = '';
        },
        error: () => {
          this.processingCancel = false;
          Swal.fire({
            icon: 'error',
            title: 'No se pudo enviar la solicitud de cancelación.',
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
          });
        },
      });
  }

  isRequestedByCurrentUser(cancelRequest: any): boolean {
    const currentUserId = this.authService.user.user;
    return cancelRequest.requestedById === currentUserId;
  }

  get hasPendingCancelRequest(): boolean {
    return this.proyecto?.cancelRequests?.some(
      (request: any) => request.status === 'PENDING'
    ) || false;
  }

  get pendingCancelRequest(): any {
    return this.proyecto?.cancelRequests?.find(
      (request: any) => request.status === 'PENDING'
    );
  }

  approveCancelation() {
    if (!this.selectedCancelRequest) return;

    this.processingCancel = true;
    this.proyectoService.approveCancel(this.proyecto.id).subscribe({
      next: () => {
        this.processingCancel = false;
        Swal.fire(
          'Cancelación aprobada',
          'El proyecto fue cancelado.',
          'success'
        );
        this.loadProjectDetails(this.proyecto.id);
        this.closeApproveModal();
      },
      error: () => {
        this.processingCancel = false;
        Swal.fire('Error', 'No se pudo aprobar la cancelación.', 'error');
      },
    });
  }

  rejectCancelation() {
    if (!this.selectedCancelRequest || !this.rejectComments.trim()) {
      Swal.fire({
        icon: 'warning',
        title: 'Motivo requerido',
        text: 'Debes ingresar un motivo para el rechazo.',
      });
      return;
    }
    this.processingCancel = true;
    this.proyectoService
      .rejectCancel(this.proyecto.id, this.rejectComments)
      .subscribe({
        next: () => {
          this.processingCancel = false;
          Swal.fire(
            'Cancelación rechazada',
            'La cancelación fue rechazada.',
            'success'
          );
          this.loadProjectDetails(this.proyecto.id);
          this.closeRejectModal();
        },
        error: () => {
          this.processingCancel = false;
          Swal.fire('Error', 'No se pudo rechazar la cancelación.', 'error');
        },
      });
  }

  private closeApproveModal() {
    (window as any).bootstrap.Modal.getOrCreateInstance(
      document.getElementById('approveCancelModal')
    ).hide();
    this.selectedCancelRequest = null;
    this.approveComments = '';
  }

  private closeRejectModal() {
    (window as any).bootstrap.Modal.getOrCreateInstance(
      document.getElementById('rejectCancelModal')
    ).hide();
    this.selectedCancelRequest = null;
    this.rejectComments = '';
  }
}
