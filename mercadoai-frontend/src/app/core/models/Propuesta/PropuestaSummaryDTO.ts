import { NecesidadSummaryDTO } from "../Necesidad/NecesidadSummaryDTO";
import { UsuarioDTO } from "../Usuario/UsuarioDTO";

// PropuestaSummaryDTO.ts
export interface PropuestaSummaryDTO {
  id: number;
  necesidad: NecesidadSummaryDTO;
  desarrollador: UsuarioDTO;
  precio: number;
  entrega: string; // ISO date string
  descripcion: string;
  estadoNombre: string;
  fechaCreacion: string; // ISO date string
}