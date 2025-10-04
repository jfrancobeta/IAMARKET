import { HitoCreateDTO } from "../Hito/HitoCreateDTO";

export interface PropuestaCreateDTO {
  necesidadId: number;
  precio: number;
  entrega: string;
  descripcion: string;
  hitos: HitoCreateDTO[];
}