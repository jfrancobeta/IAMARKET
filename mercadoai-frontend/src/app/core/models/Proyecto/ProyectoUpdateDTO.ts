import { HitoUpdateDTO } from "../Hito/HitoUpdateDTO";

export interface ProyectoUpdateDTO {
  presupuesto?: number;
  fechaInicio?: string;
  fechaFin?: string;
  hitos?: HitoUpdateDTO[]; 
}