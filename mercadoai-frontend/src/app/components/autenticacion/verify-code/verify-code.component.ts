import { Component } from '@angular/core';
import { UsuariosService } from '../../../services/usuarios.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-verify-code',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './verify-code.component.html'
})
export class VerifyCodeComponent {

  verifyCodeRequest = {
    email: '',
    code: ''
  };
  codeDigits: string[] = ['', '', '', '', '', ''];

  constructor(private usuariosService: UsuariosService,
    private router: Router
  ) { 
    // Inicializar el objeto si es necesario
    this.verifyCodeRequest = {
      email: '',
      code: ''
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
          timerProgressBar: true
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
          timerProgressBar: true
        });
      }
    });
  }

}

