import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { RegistroRequest } from '../../../models/RegistroRequest';
import { UsuariosService } from '../../../services/usuarios.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-registro-login',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './registro-login.component.html',
})
export class RegistroLoginComponent implements OnInit {
  
  registroRequest: RegistroRequest;

  constructor(private service: UsuariosService){
    this.registroRequest = new RegistroRequest();
  }
  ngOnInit(): void {
    
  }

  onsubmit(userForm: NgForm) {
    if(userForm.valid) {
      this.service.registrarUsuario(this.registroRequest).subscribe({
        next: (response) => {
          console.log('Registro exitoso', response);
          // Aquí podrías redirigir al usuario a otra página o mostrar un mensaje de éxito
        },
        error: (error) => {
          console.error('Error en el registro', error);
          // Aquí podrías mostrar un mensaje de error al usuario
        }
      });
    }
  }

  

}
