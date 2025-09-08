import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';
import { RegistroRequest } from '../../../../core/models/auth/RegistroRequest';
import { HabilidadDTO } from '../../../../core/models/Habilidad/HabilidadDTO';
import { IndustriaDTO } from '../../../../core/models/Industria/IndustriaDTO';
import { PaisDTO } from '../../../../core/models/Pais/PaisDTO';
import { HabilidadService } from '../../../../core/services/habilidad.service';
import { IndustriaService } from '../../../../core/services/industria.service';
import { PaisService } from '../../../../core/services/pais.service';
import { UsuariosService } from '../../../../core/services/usuarios.service';

@Component({
  selector: 'app-registro-login',
  standalone: true,
  imports: [RouterModule, FormsModule, CommonModule],
  templateUrl: './registro-login.component.html',
})
export class RegistroLoginComponent implements OnInit {
  registroRequest: RegistroRequest;

  paises: PaisDTO[] = [];

  industrias: IndustriaDTO[] = [];

  habilidadesList: (HabilidadDTO & { checked?: boolean })[] = [];
  selectedHabilidades: HabilidadDTO[] = [];

  constructor(
    private service: UsuariosService,
    private paisService: PaisService,
    private industriaService: IndustriaService,
    private habilidadService: HabilidadService,
    private router: Router
  ) {
    this.registroRequest = new RegistroRequest();
  }
  ngOnInit(): void {
    this.paisService.getPaises().subscribe({
      next: (response) => {
        this.paises = response;
      },
    });

    this.industriaService.getIndustrias().subscribe({
      next: (response) => {
        this.industrias = response;
      },
    });

    this.habilidadService.getAll().subscribe({
      next: (response) => {
        this.habilidadesList = response.map((skill) => ({
          ...skill,
          checked: false,
        }));
      },
    });
  }

  onsubmit(userForm: NgForm) {
    if (userForm.valid) {
      console.log(this.registroRequest);
      this.service.registrarUsuario(this.registroRequest).subscribe({
        next: (response) => {
          Swal.fire({
            icon: 'success',
            title: '¡Registro exitoso!',
            text: 'Tu cuenta ha sido creada correctamente.',
            confirmButtonText: 'Ir al login',
          }).then(() => {
            this.router.navigate(['/auth']);
          });
        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Error en el registro',
            text: error.error || 'Ocurrió un error al registrar el usuario.',
          });
          console.error('Error al registrar usuario:', error);
        },
      });
    }
  }

  confirmSkills() {
    this.selectedHabilidades = this.habilidadesList.filter(
      (skill) => skill.checked
    );
    this.registroRequest.habilidades = this.selectedHabilidades.map(
      (skill) => skill.id
    );
  }

  removeSkill(skill: HabilidadDTO) {
    // Desmarca el skill en la lista
    const found = this.habilidadesList.find((s) => s.id === skill.id);
    if (found) found.checked = false;
    this.confirmSkills();
  }
}
