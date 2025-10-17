import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { UsuarioDTO } from '../../../core/models/Usuario/UsuarioDTO';
import { ProfileService } from '../services/profile.service';
import Swal from 'sweetalert2';
import { AuthService } from '../../../core/services/auth.service';
import { CommonModule, DatePipe } from '@angular/common';
import {
  FormArray,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { HabilidadDTO } from '../../../core/models/Habilidad/HabilidadDTO';
import { UserPersonalUpdateDTO } from '../../../core/models/Usuario/UserPersonalUpdateDTO';
import { ProfileDeveloperUpdateDTO } from '../../../core/models/Perfil/ProfileDeveloperUpdateDTO';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [
    MainLayoutComponent,
    DatePipe,
    ReactiveFormsModule,
    CommonModule,
    RouterLink,
  ],
  templateUrl: './profile.component.html',
})
export class ProfileComponent implements OnInit {
  usuario!: UsuarioDTO;
  username: string = '';

  personalForm!: FormGroup;
  professionalForm!: FormGroup;

  isEditingPersonal = false;
  isEditingProfessional = false;
  isLoading = false;

  imagePreview: string | null = null;
  selectedFile: File | null = null;

  constructor(
    private profileService: ProfileService,
    private authService: AuthService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.initForms();
    this.loadUsername();
    this.loadUserData();
  }

  loadUsername() {
    this.username = this.authService.user.user.username;
  }

  private initForms(): void {
    this.personalForm = this.fb.group({
      nombre: [
        { value: '', disabled: true },
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(100),
        ],
      ],
      email: [
        { value: '', disabled: true },
        [Validators.required, Validators.email],
      ],
      pais: [{ value: '', disabled: true }, [Validators.required]],
      descripcion: [{ value: '', disabled: true }, [Validators.maxLength(500)]],
      foto: [''],
    });

    this.professionalForm = this.fb.group({
      anosExperiencia: [{ value: '', disabled: true }, [Validators.required]],
      habilidades: this.fb.array([]),
      portfolioUrl: [
        { value: '', disabled: true },
        [Validators.pattern(/^https?:\/\/.+/)],
      ],
      githubUrl: [
        { value: '', disabled: true },
        [
          Validators.required,
          Validators.pattern(/^https?:\/\/(www\.)?github\.com\/.+/)
        ],
      ],
      linkedinUrl: [
        { value: '', disabled: true },
        [
          Validators.required,
          Validators.pattern(/^https?:\/\/(www\.)?linkedin\.com\/.+/)
        ],
      ],
    });
  }

  loadUserData() {
    this.isLoading = true;
    this.profileService.getUserByUsername(this.username).subscribe({
      next: (data) => {
        this.usuario = data;
        this.populateForms(data);
        this.isLoading = false;
        console.log(this.usuario);
      },
      error: (error) => {
        Swal.fire(
          'Error',
          'No se pudo cargar la información del usuario.',
          'error'
        );
        this.isLoading = false;
      },
    });
  }

  private populateForms(usuario: UsuarioDTO): void {
    console.log('populateForms usuario', usuario);
    this.personalForm.patchValue({
      nombre: usuario.nombre,
      email: usuario.email,
      pais: usuario.pais,
      descripcion: usuario.descripcion,
      foto: usuario.foto,
    });

    // Llenar formulario profesional
    this.professionalForm.patchValue({
      anosExperiencia: usuario.perfilDesarrollador.experiencia,
      portfolioUrl: usuario.perfilDesarrollador.portafolioURL,
      githubUrl: usuario.perfilDesarrollador.githubURL,
      linkedinUrl: usuario.perfilDesarrollador.linkedinURL,
    });

    // Agregar habilidades
    const habilidadesArray = this.habilidades;
    habilidadesArray.clear();

    if (Array.isArray(usuario.perfilDesarrollador.habilidades)) {
      usuario.perfilDesarrollador.habilidades.forEach(
        (habilidad: HabilidadDTO) => {
          habilidadesArray.push(
            this.fb.group({
              id: [habilidad.id],
              nombre: [habilidad.nombre, Validators.required],
            })
          );
        }
      );
    }

    console.log('habilidades', habilidadesArray);
  }

  get habilidades(): FormArray {
    return this.professionalForm.get('habilidades') as FormArray;
  }

  agregarHabilidad(habilidad: string): void {
    if (habilidad && habilidad.trim()) {
      this.habilidades.push(this.fb.control(habilidad.trim()));
    }
  }

  eliminarHabilidad(index: number): void {
    this.habilidades.removeAt(index);
  }

  toggleEditPersonal(): void {
    this.isEditingPersonal = !this.isEditingPersonal;

    if (this.isEditingPersonal) {
      this.personalForm.get('nombre')?.enable();
      this.personalForm.get('pais')?.enable();
      this.personalForm.get('descripcion')?.enable();
      // Email no se puede editar
    } else {
      this.personalForm.get('nombre')?.disable();
      this.personalForm.get('pais')?.disable();
      this.personalForm.get('descripcion')?.disable();
      // Restaurar valores originales si cancela
      this.populateForms(this.usuario);
    }
  }

  toggleEditProfessional(): void {
    this.isEditingProfessional = !this.isEditingProfessional;

    if (this.isEditingProfessional) {
      this.professionalForm.get('anosExperiencia')?.enable();
      this.professionalForm.get('portfolioUrl')?.enable();
      this.professionalForm.get('githubUrl')?.enable();
      this.professionalForm.get('linkedinUrl')?.enable();
      Object.values(this.professionalForm.controls).forEach(control => control.markAsUntouched());
    } else {
      this.professionalForm.get('anosExperiencia')?.disable();
      this.professionalForm.get('portfolioUrl')?.disable();
      this.professionalForm.get('githubUrl')?.disable();
      this.professionalForm.get('linkedinUrl')?.disable();
      this.populateForms(this.usuario);
    }
  }

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];

      // Validar tipo de archivo
      if (!file.type.startsWith('image/')) {
        Swal.fire('Error', 'Por favor selecciona una imagen válida', 'error');
        return;
      }

      // Validar tamaño (máximo 5MB)
      if (file.size > 5 * 1024 * 1024) {
        Swal.fire('Error', 'La imagen no debe superar los 5MB', 'error');
        return;
      }

      this.selectedFile = file;

      // Preview
      const reader = new FileReader();
      reader.onload = () => {
        this.imagePreview = reader.result as string;
      };
      reader.readAsDataURL(file);
    }
  }

  uploadImage(): void {
    if (!this.selectedFile) return;

    this.isLoading = true;
    this.profileService
      .uploadProfilePhoto(this.usuario.id, this.selectedFile)
      .subscribe({
        next: (response) => {
          this.usuario.foto = response.toString();
          this.personalForm.patchValue({ foto: response.toString() });
          this.imagePreview = null;
          this.selectedFile = null;

          Swal.fire({
            icon: 'success',
            title: 'Imagen actualizada',
            text: 'Tu foto de perfil se actualizó correctamente',
            timer: 2000,
            showConfirmButton: false,
          });

          this.isLoading = false;
        },
        error: (error) => {
          console.error('Error al subir imagen:', error);
          Swal.fire('Error', 'No se pudo subir la imagen', 'error');
          this.isLoading = false;
        },
      });
  }

  // Guardar cambios
  savePersonal(): void {
    if (this.personalForm.invalid) {
      this.personalForm.markAllAsTouched();
      return;
    }

    const formValue = this.personalForm.getRawValue();
    const updateData: UserPersonalUpdateDTO = {
      nombre: formValue.nombre,
      email: formValue.email,
      descripcion: formValue.descripcion,
      paisId: formValue.pais.id,
    };
    console.log('updateData', updateData);
    this.isLoading = true;
    this.profileService
      .updateUserPersonal(this.usuario.id, updateData)
      .subscribe({
        next: (response) => {
          this.usuario = { ...this.usuario, ...response };
          this.toggleEditPersonal();
          Swal.fire({
            icon: 'success',
            title: '¡Actualizado!',
            text: 'Los cambios se guardaron correctamente',
            timer: 2000,
            showConfirmButton: false,
          });
          this.isLoading = false;
        },
        error: (error) => {
          console.error('Error al actualizar perfil:', error);
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'No se pudieron guardar los cambios',
            confirmButtonColor: '#d33',
          });
          this.isLoading = false;
        },
      });
  }

  saveProfessional(): void {
    if (this.professionalForm.invalid) {
      this.professionalForm.markAllAsTouched();
      return;
    }

    const formValue = this.professionalForm.getRawValue();
    const updateData: ProfileDeveloperUpdateDTO = {
      portafolioURL: formValue.portfolioUrl,
      githubURL: formValue.githubUrl,
      linkedinURL: formValue.linkedinUrl,
      habilidad: formValue.habilidades,
      experiencia: formValue.anosExperiencia,
    };

    this.isLoading = true;
  this.profileService
    .updateDeveloperProfile(this.usuario.id, updateData)
    .subscribe({
      next: (response) => {
        // Actualiza solo el perfil de desarrollador
        this.usuario.perfilDesarrollador = response;
        this.toggleEditProfessional();
        Swal.fire({
          icon: 'success',
          title: '¡Actualizado!',
          text: 'Los cambios se guardaron correctamente',
          timer: 2000,
          showConfirmButton: false,
        });
        this.isLoading = false;
      },
      error: (error) => {
        console.error('Error al actualizar perfil:', error);
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'No se pudieron guardar los cambios',
          confirmButtonColor: '#d33',
        });
        this.isLoading = false;
      },
    });
  }

  // Getters para validaciones
  get nombreInvalid() {
    const control = this.personalForm.get('nombre');
    return control?.invalid && control?.touched;
  }

  get emailInvalid() {
    const control = this.personalForm.get('email');
    return control?.invalid && control?.touched;
  }

  get paisInvalid() {
    const control = this.personalForm.get('pais');
    return control?.invalid && control?.touched;
  }

  
}
