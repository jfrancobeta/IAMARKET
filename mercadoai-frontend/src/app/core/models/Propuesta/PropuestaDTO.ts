import { EstadoDTO } from "../Estado/EstadoDTO";
import { HitoDTO } from "../Hito/HitoDTO";
import { NecesidadDTO } from "../Necesidad/NecesidadDTO";
import { UsuarioDTO } from "../Usuario/UsuarioDTO";

export interface PropuestaDTO {
  id: number;
  necesidad: NecesidadDTO;
  desarrollador: UsuarioDTO;
  precio: number;
  entrega: string; 
  descripcion: string;
  estado: EstadoDTO;
  hitos: HitoDTO[];
  fechaCreacion: string; 
}