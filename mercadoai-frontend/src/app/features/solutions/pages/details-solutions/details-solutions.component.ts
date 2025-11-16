import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
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
import { CommonModule, DatePipe, DecimalPipe } from '@angular/common';
import { AuthService } from '../../../../core/services/auth.service';
import { PaymentService } from '../../../../core/services/payment.service';
import { PaymentResponseDTO } from '../../../../core/models/payment/PaymentResponseDTO';
import { PaymentCreateDTO } from '../../../../core/models/payment/PaymentcreateDTO';

@Component({
  selector: 'app-details-solutions',
  standalone: true,
  imports: [
    MainLayoutComponent,
    RouterModule,
    DatePipe,
    DecimalPipe,
    CommonModule,
  ],
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
    hitos: [],
    tiempoEntrega: 0,
    unidadEntrega: UnidadEntrega.Dias,
    fechaCreacion: '',
    fechaActualizacion: '',
    desarrollador: {} as UsuarioDTO,
  };

  isOwner: boolean = false;
  constructor(
    private solucionService: SolutionService,
    private route: ActivatedRoute,
    private authService: AuthService,
    private paymentService: PaymentService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadSolucion();
  }

  buyNow(){
  this.paymentService.createPendingPayment(this.SolucionDTO.id, "solucion").subscribe({
   next: (response: PaymentResponseDTO) => {
        // Si el backend responde con una URL de pago, redirige
        if (response && response.initPoint) {
          Swal.fire({
            title: 'Redirigiendo al pago...',
            text: 'Serás redirigido a la plataforma de pago.',
          }).then(() => {
            window.location.href = response.initPoint;
          });
        } else {
          // Maneja el caso de éxito sin redirección
          alert('Pago creado correctamente');
        }
      },
      error: (err) => {
        alert('No se pudo iniciar el pago');
        console.error(err);
      }
    });
  }

  private loadSolucion(): void {
    const solucionId = this.route.snapshot.paramMap.get('id');
    if (solucionId) {
      this.solucionService.getById(+solucionId).subscribe({
        next: (solucion) => {
          console.log('Loaded solution:', solucion);
          this.SolucionDTO = solucion;
          this.checkOwnership();
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

  private checkOwnership(): void {
    const userId = this.authService.user?.usuario;
    this.isOwner = this.SolucionDTO.desarrollador.id === userId;
  }

  onDelete(): void {
    Swal.fire({
      title: '¿Estás seguro?',
      text: 'Esta acción no se puede deshacer.',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, eliminar',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        this.solucionService.delete(this.SolucionDTO.id).subscribe({
          next: (response) => {
            console.log('Delete response:', response);
            Swal.fire({
              icon: 'success',
              title: 'Eliminado',
              text: 'La solución ha sido eliminada.',
            }).then(() => {
              this.router.navigate(['/solutions']);
            });
          },
          error: (err: any) => {
            Swal.fire({
              icon: 'error',
              title: 'Error',
              text: 'No se pudo eliminar la solución. Por favor, inténtelo de nuevo más tarde.',
            });
            console.error('Error deleting solution:', err);
          },
        });
      }
    });
  }
}
