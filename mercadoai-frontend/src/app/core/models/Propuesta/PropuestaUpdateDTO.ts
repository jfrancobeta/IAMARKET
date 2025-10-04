import { HitoUpdateDTO } from "../Hito/HitoUpdateDTO";

export interface PropuestaUpdateDTO {
  precio: number;
  entrega: string;
  descripcion: string;
  hitos: HitoUpdateDTO[];
}