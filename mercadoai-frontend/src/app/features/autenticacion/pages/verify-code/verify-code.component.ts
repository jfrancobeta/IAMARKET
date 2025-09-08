import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { UsuariosService } from '../../../../core/services/usuarios.service';

@Component({
  selector: 'app-verify-code',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterModule],
  templateUrl: './verify-code.component.html',
})
export class VerifyCodeComponent {
  verifyCodeRequest = {
    email: '',
    code: '',
  };
  codeDigits: string[] = ['', '', '', '', '', ''];

  constructor(
    private usuariosService: UsuariosService,
    private router: Router
  ) {
    // Inicializar el objeto si es necesario
    this.verifyCodeRequest = {
      email: '',
      code: '',
    };
  }

  onInput(event: any, index: number) {
    const input = event.target;
    if (input.value.length === 1 && index < 5) {
      input.nextElementSibling?.focus();
    }
  }

  onSubmit() {
    this.verifyCodeRequest.email = sessionStorage.getItem('resetEmail') || '';
    this.verifyCodeRequest.code = this.codeDigits.join('');
    this.usuariosService.verifyResetCode(this.verifyCodeRequest).subscribe({
      next: (response) => {
        Swal.fire({
          toast: true,
          position: 'top-end',
          icon: 'success',
          title: '¡Código verificado con éxito!',
          showConfirmButton: false,
          timer: 2500,
          timerProgressBar: true,
        });
        sessionStorage.setItem('resetCode', this.verifyCodeRequest.code);
        this.router.navigate(['/reset-password']);
      },
      error: (error) => {
        console.error('Error al verificar el código:', error);
        Swal.fire({
          toast: true,
          position: 'top-end',
          icon: 'error',
          title: 'Error al verificar el código. Intenta de nuevo.',
          showConfirmButton: false,
          timer: 2500,
          timerProgressBar: true,
        });
      },
    });
  }

  onResendCode() {
    const email = sessionStorage.getItem('resetEmail') || '';
    if (!email) {
      Swal.fire({
        toast: true,
        position: 'top-end',
        icon: 'error',
        title: 'No se encontró el correo para reenviar el código',
        showConfirmButton: false,
        timer: 2500,
        timerProgressBar: true,
      });
      return;
    }
    this.usuariosService.sendResetCode({ email }).subscribe({
      next: () => {
        Swal.fire({
          toast: true,
          position: 'top-end',
          icon: 'success',
          title: '¡Código reenviado!',
          showConfirmButton: false,
          timer: 2500,
          timerProgressBar: true,
        });
      },
      error: () => {
        Swal.fire({
          toast: true,
          position: 'top-end',
          icon: 'error',
          title: 'Error al reenviar el código. Intenta de nuevo.',
          showConfirmButton: false,
          timer: 2500,
          timerProgressBar: true,
        });
      },
    });
  }
}
