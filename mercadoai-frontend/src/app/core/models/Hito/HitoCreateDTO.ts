import { EntregableCreateDTO } from "../Entregable/EntregableCreateDTO";

export interface HitoCreateDTO {
  nombre: string;
  descripcion: string;
  fechaEntrega: string;
  entregables: EntregableCreateDTO[];
}