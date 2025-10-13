import { NecesidadDTO } from "../Necesidad/NecesidadDTO";
import { PropuestaDTO } from "../Propuesta/PropuestaDTO";
import { PropuestaSummaryDTO } from "../Propuesta/PropuestaSummaryDTO";
import { SolucionDTO } from "../Solucion/SolucionDTO";
import { SolucionSummaryDTO } from "../Solucion/SolucionSummaryDTO";

export interface ProyectoSummaryDTO {
  id?: number;
  solucion?: SolucionSummaryDTO; 
  propuesta?: PropuestaSummaryDTO; 
}