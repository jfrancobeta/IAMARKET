import { HitoUpdateDTO } from "../Hito/HitoUpdateDTO";

export interface SolucionUpdateDTO {
  titulo: string;
  descripcion: string;
  precio: number;
  categoriaId: number;
  estadoId: number;
  habilidadesIds: number[];
  caracteristicas: string[];
  requisitos: string[];
  hitos: HitoUpdateDTO[];
  tiempoEntrega: number;
  unidadEntrega: string;
}