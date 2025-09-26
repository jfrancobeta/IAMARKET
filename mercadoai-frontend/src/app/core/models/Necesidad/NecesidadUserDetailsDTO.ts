import { HitoDTO } from "../Hito/HitoDTO";
import { PropuestaUserDetailsDTO } from "../Propuesta/PropuestaUserDetailsDTO";
import { UsuarioCalificacionDTO } from "../Usuario/UsuarioCalificacionDTO";

export interface NecesidadUserDetailsDTO {
  id: number;
  titulo: string;
  descripcion: string;
  categoria: string;
  presupuesto: number; // o string si tu backend lo envía como texto
  compania: UsuarioCalificacionDTO;
  fechaLimite: string; // o Date si lo conviertes después
  skillsRequired: string[];
  requirements: string[];
  hitos: HitoDTO[];
  estadoNombre: string;
  propuestas: PropuestaUserDetailsDTO[];
  fechaCreacion: string; // o Date si lo conviertes después
  fechaActualizacion: string; // o Date si lo conviertes después
}