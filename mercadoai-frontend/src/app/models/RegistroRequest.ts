export class RegistroRequest {
    username!: string;
    email!: string;
    password!: string;
    userType!: number; // 0: Compañía, 1: Desarrollador
    nombre!: string;
    descripcion!: string;
    roles!: Role[];
  
    // Campos específicos para desarrollador
    habilidades?: string;
    experiencia?: number;
    portafolioURL?: string;
  
    // Campos específicos para compañía
    nombreCompania?: string;
    industria?: string;
    website?: string;
    ubicacion?: string;
  }
  
  export class Role {
    id!: number;
    name!: string;
  }