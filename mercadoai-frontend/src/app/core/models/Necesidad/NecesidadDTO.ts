import { CategoriaDTO } from "../Categoria/CategoriaDTO";
import { EstadoDTO } from "../Estado/EstadoDTO";
import { HabilidadDTO } from "../Habilidad/HabilidadDTO";
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
  expectedDeliverables: string[];
  estado: EstadoDTO;
  fechaCreacion?: string; 
  fechaActualizacion?: string; 
}