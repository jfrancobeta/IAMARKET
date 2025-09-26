import { CategoriaDTO } from "../Categoria/CategoriaDTO";
import { EstadoDTO } from "../Estado/EstadoDTO";
import { HabilidadDTO } from "../Habilidad/HabilidadDTO";
import { HitoDTO } from "../Hito/HitoDTO";
import { Usuario } from "../Usuario/Usuario";
import { UsuarioDTO } from "../Usuario/UsuarioDTO";

export interface NecesidadDTO {
  id?: number; 
  titulo: string;
  descripcion: string;
  categoria: CategoriaDTO;
  presupuesto: number; 
  compania: UsuarioDTO; 
  fechaLimite: string;
  skillsRequired: HabilidadDTO[];
  requirements: string[];
  hitos: HitoDTO[];
  estado: EstadoDTO;
  fechaCreacion?: string; 
  fechaActualizacion?: string; 
}