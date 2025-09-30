import { HitoDTO } from "../Hito/HitoDTO";

export interface ProyectoDTO {
  id?: number;
  solucionId?: number;
  propuestaId?: number;
  presupuesto?: number;
  fechaInicio?: string;
  fechaFin?: string;
  estado?: string;
  hitos?: HitoDTO[];
}