import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { UsuarioDTO } from '../../../core/models/Usuario/UsuarioDTO';
import { ProfileService } from '../services/profile.service';
import Swal from 'sweetalert2';
import { AuthService } from '../../../core/services/auth.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [MainLayoutComponent,DatePipe],
  templateUrl: './profile.component.html',
})
export class ProfileComponent implements OnInit {
  usuario!: UsuarioDTO;
  username: string = 'username'; 
  constructor(
    private profileService: ProfileService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.loadUsername();
    this.loadUserData();
  }

  loadUsername() {
    this.username = this.authService.user.user.username;
  }
  loadUserData() {
    this.profileService.getUserByUsername(this.username).subscribe({
      next: (data) => {
        this.usuario = data;
      },
      error: (error) => {
        Swal.fire('Error', 'No se pudo cargar la información del usuario.', 'error');
      }
    });
  }
}
