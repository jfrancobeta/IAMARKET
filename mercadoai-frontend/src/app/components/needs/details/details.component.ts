import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from "../../layout/main-layout/main-layout.component";
import { ActivatedRoute, RouterModule } from '@angular/router';
import { NeedService } from '../../../services/need.service';
import { Necesidad } from '../../../models/need/Necesidad';
import Swal from 'sweetalert2';
import { AuthService } from '../../../services/auth.service';
import { NecesidadResponseDTO } from '../../../models/need/NecesidadResponseDTO';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [MainLayoutComponent,RouterModule],
  templateUrl: './details.component.html',
})
export class DetailsComponent implements OnInit {

  id: string | null = null;
  need: NecesidadResponseDTO | null = null;
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
    this.needsService.getById(Number(this.id)).subscribe(
      {
        next: (data) => {
          this.need = data;
          this.isOwner = this.need.compania.id === this.authService.user.usuario;
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
