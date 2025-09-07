export class RegistroRequest {
    username!: string;
    email!: string;
    password!: string;
    userType: number = 0; // 0: Compañía, 1: Desarrollador
    nombre!: string;
    descripcion!: string;
    roles!: Role[];
    pais?: number;
  
    // Campos específicos para desarrollador
    habilidades?: number[];
    experiencia?: number;
    portafolioURL?: string;
  
    // Campos específicos para compañía
    nombreCompania?: string;
    industria?: number;
    website?: string;
    
  }
  
  export class Role {
    id!: number;
    name!: string;
  }