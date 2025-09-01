import { CategoriaDTO } from "../Categoria/CategoriaDTO";

export interface NecesidadSummaryDTO {
  id: number;
  titulo: string;
  categoria: CategoriaDTO;
  presupuesto: number; 
  descripcion: string;
  companiaNombre: string;
  fechaLimite: string; 
  estadoNombre: string;
  propuestas: number;
  fechaCreacion: string; 
}