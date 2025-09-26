import { EntregableDTO } from "../Entregable/EntregableDTO";

export interface HitoDTO {
  id: number;
  nombre: string;
  descripcion: string;
  fechaEntrega: string; 
  entregables: EntregableDTO[];
}