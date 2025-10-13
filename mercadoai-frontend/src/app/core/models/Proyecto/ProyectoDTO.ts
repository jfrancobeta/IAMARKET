import { HitoDTO } from "../Hito/HitoDTO";
import { PropuestaDTO } from "../Propuesta/PropuestaDTO";
import { SolucionDTO } from "../Solucion/SolucionDTO";
import { UsuarioDTO } from "../Usuario/UsuarioDTO";

export interface ProyectoDTO {
  id: number;
  solucion: SolucionDTO;
  propuesta: PropuestaDTO;
  empresa: UsuarioDTO;
  desarrollador: UsuarioDTO;
  presupuesto: number;
  fechaInicio: string;
  fechaFin: string;
  estado: string;
  hitos: HitoDTO[];
}