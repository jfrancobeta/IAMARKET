import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { ResetCodeRequest } from '../../../models/auth-reset.model';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { UsuariosService } from '../../../services/usuarios.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-forgot-password',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './forgot-password.component.html',
})
export class ForgotPasswordComponent {

  ResetCodeRequest: ResetCodeRequest = {
    email: ''
  };

  constructor(private router: Router,
              private usuariosService: UsuariosService
  ) { }

  onSubmit() {
    this.usuariosService.sendResetCode(this.ResetCodeRequest).subscribe({
      next: (response) => {
        Swal.fire({
          toast: true,
          position: 'top-end',
          icon: 'success',
          title: '¡Enviamos tu código!',
          showConfirmButton: false,
          timer: 2500,
          timerProgressBar: true
        });
        sessionStorage.setItem('resetEmail', this.ResetCodeRequest.email);
        this.router.navigate(['/verify-code']);
      },
      error: (error) => {
        console.error('Error al enviar el código de recuperación:', error);
        Swal.fire({
          toast: true,
          position: 'top-end',
          icon: 'error',
          title: 'Error al enviar el código. Intenta de nuevo.',
          showConfirmButton: false,
          timer: 2500,
          timerProgressBar: true
        });
      }
    });
  }

}
