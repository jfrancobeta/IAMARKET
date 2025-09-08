import { PerfilCompaniaDTO } from "../Perfil/PerfilCompaniaDTO";
import { PerfilDesarrolladorDTO } from "../Perfil/PerfilDesarrolladorDTO";

export interface UsuarioDTO {
  id: number;
  username: string;
  email: string;
  nombre: string;
  descripcion: string;
  foto: string;
  userType: number;
  estado: boolean;
  fechaCreacion: string; // o Date si lo conviertes después
  fechaActualizacion: string; // o Date si lo conviertes después
  roles: string[];
  perfilCompania: PerfilCompaniaDTO;
  perfilDesarrollador: PerfilDesarrolladorDTO;
}