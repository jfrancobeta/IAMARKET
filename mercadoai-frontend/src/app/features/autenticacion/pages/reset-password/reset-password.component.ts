import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { UsuariosService } from '../../../../core/services/usuarios.service';

@Component({
  selector: 'app-reset-password',
  standalone: true,
  imports: [FormsModule, RouterModule, CommonModule],
  templateUrl: './reset-password.component.html',
})
export class ResetPasswordComponent {
  ResetPasswordRequest = {
    email: sessionStorage.getItem('resetEmail') || '',
    code: sessionStorage.getItem('resetCode') || '',
    newPassword: '',
  };
  password: string = '';
  confirmPassword: string = '';

  constructor(private router: Router,
    private usuariosService: UsuariosService
  ) {}

  onSubmit() {
    if (this.password !== this.confirmPassword) {
      Swal.fire({
        toast: true,
        position: 'top-end',
        icon: 'error',
        title: 'Las contraseñas no coinciden',
        showConfirmButton: false,
        timer: 2500,
        timerProgressBar: true
      });
      return;
    }
    this.ResetPasswordRequest.newPassword = this.password;
    this.usuariosService.resetPassword(this.ResetPasswordRequest).subscribe({
      next: (response) => {
        Swal.fire({
          toast: true,
          position: 'top-end',
          icon: 'success',
          title: '¡Contraseña reseteada con éxito!',
          showConfirmButton: false,
          timer: 2500,
          timerProgressBar: true
        });
        sessionStorage.removeItem('resetEmail');
        sessionStorage.removeItem('resetCode');
        this.router.navigate(['/auth']);
      },
      error: (error) => {
        console.error('Error al resetear la contraseña:', error);
        Swal.fire({
          toast: true,
          position: 'top-end',
          icon: 'error',
          title: 'Error al resetear la contraseña. Intenta de nuevo.',
          showConfirmButton: false,
          timer: 2500,
          timerProgressBar: true
        });
      }
    });
  }
}
