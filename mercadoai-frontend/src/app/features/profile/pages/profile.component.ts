import { Component } from '@angular/core';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { UsuarioDTO } from '../../../core/models/Usuario/UsuarioDTO';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [MainLayoutComponent],
  templateUrl: './profile.component.html',
})
export class ProfileComponent {
  usuario!: UsuarioDTO;

}
