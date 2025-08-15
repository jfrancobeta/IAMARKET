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
  fechaCreacion: string; 
  fechaActualizacion: string; 
}