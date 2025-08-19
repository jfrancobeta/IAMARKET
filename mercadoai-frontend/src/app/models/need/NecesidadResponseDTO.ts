import { Propuesta } from "../Propuestas";
import { Usuario } from "../Usuario";

export interface NecesidadResponseDTO {
  id: number;
  titulo: string;
  descripcion: string;
  categoria: string;
  presupuesto: number; 
  compania: Usuario; 
  fechaLimite: string;
  skillsRequired: string[];
  requirements: string;
  expectedDeliverables: string[];
  estadoNombre: string;
  propuestas: Propuesta[];
  fechaCreacion: string; 
  fechaActualizacion: string; 
}