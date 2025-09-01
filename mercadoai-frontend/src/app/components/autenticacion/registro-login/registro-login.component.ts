import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { RegistroRequest } from '../../../models/RegistroRequest';
import { UsuariosService } from '../../../services/usuarios.service';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-registro-login',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './registro-login.component.html',
})
export class RegistroLoginComponent implements OnInit {
  
  registroRequest: RegistroRequest;

  constructor(private service: UsuariosService, private router: Router) {
    this.registroRequest = new RegistroRequest();
  }
  ngOnInit(): void {
    
  }

  onsubmit(userForm: NgForm) {
    if(userForm.valid) {
      console.log(this.registroRequest);
      this.service.registrarUsuario(this.registroRequest).subscribe({
        next: (response) => {
          Swal.fire({
            icon: 'success',
            title: '¡Registro exitoso!',
            text: 'Tu cuenta ha sido creada correctamente.',
            confirmButtonText: 'Ir al login'
          }).then(() => {
            this.router.navigate(['/auth']);
          });
        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Error en el registro',
            text: error.error || 'Ocurrió un error al registrar el usuario.'
          });
          console.error('Error al registrar usuario:', error);
        }
      });
    }
  }

  

}
