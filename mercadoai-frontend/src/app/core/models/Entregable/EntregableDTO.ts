import { EstadoDTO } from "../Estado/EstadoDTO";

export interface EntregableDTO {
  id: number;
  nombreArchivo: string;
  url: string | null;
  estado: EstadoDTO;
  fechaEntrega: string | null; 
}