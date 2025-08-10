export class Usuario {
  id?: number;
  username!: string;
  email!: string;
  password?: string;
  userType!: number;
  nombre!: string;
  roles?: string[];
  descripcion?: string;
  fechaCreacion?: string;
  fechaActualizacion?: string;
  estado?: boolean;
  perfilCompania?: PerfilCompania;
  perfilDesarrollador?: PerfilDesarrollador;
}

export interface PerfilCompania {
  id: number;
  nombreCompania: string;
  industria: string;
  website: string;
  ubicacion: string;
}

// PerfilDesarrollador.ts
export interface PerfilDesarrollador {
  id: number;
  habilidades: string;
  experiencia: number;
  portafolioURL: string;
}