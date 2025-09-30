import { NecesidadDTO } from "../Necesidad/NecesidadDTO";
import { PropuestaDTO } from "../Propuesta/PropuestaDTO";
import { SolucionDTO } from "../Solucion/SolucionDTO";

export interface ProyectoSummaryDTO {
  id?: number;
  solucion?: SolucionDTO; 
  propuesta?: PropuestaDTO; 
}