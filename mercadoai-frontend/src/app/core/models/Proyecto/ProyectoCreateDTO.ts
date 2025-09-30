import { HitoCreateDTO } from "../Hito/HitoCreateDTO";

export interface ProyectoCreateDTO {
  id?: number;
  solucionId?: number;
  propuestaId?: number;
  presupuesto?: number; 
  fechaInicio?: string; 
  fechaFin?: string;    
  hitos?: HitoCreateDTO[]; 
}