import { Component, OnInit } from '@angular/core';
import { RouterModule, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';
import { NecesidadUserDetailsDTO } from '../../../../core/models/Necesidad/NecesidadUserDetailsDTO';
import { AuthService } from '../../../../core/services/auth.service';
import { MainLayoutComponent } from '../../../../shared/layout/main-layout/main-layout.component';
import { NeedService } from '../../services/need.service';
import { CommonModule, DatePipe } from '@angular/common';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [MainLayoutComponent,RouterModule,DatePipe,CommonModule],
  templateUrl: './details.component.html',
})
export class DetailsComponent implements OnInit {

  id: string | null = null;
  need: NecesidadUserDetailsDTO | null = null;
  isOwner: boolean = false;
  roles: string[] = [];
  
  constructor(private router: ActivatedRoute,
    private needsService: NeedService,
    private authService: AuthService
  ) {
    this.id = this.router.snapshot.paramMap.get('id');
  }
  ngOnInit(): void {
    this.roles = this.authService.getRoles();
    this.needsService.getByidDetails(Number(this.id)).subscribe(
      {
        next: (data) => {
          this.need = data;
          console.log(this.need);
          this.isOwner = !!this.need && !!this.need.compania && this.need.compania.id === this.authService.user.usuario;
        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'No se pudo obtener los detalles de la necesidad.',
          });
        }
      });

  }



}
