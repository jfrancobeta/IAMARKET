import { EntregableUpdateDTO } from "../Entregable/EntregableUpdateDTO";

export interface HitoUpdateDTO {
  id: number;
  nombre: string;
  descripcion: string;
  fechaEntrega: string;
  entregables: EntregableUpdateDTO[];
}