import { HitoCreateDTO } from "../Hito/HitoCreateDTO";

export interface SolucionCreateDTO {
  titulo: string;
  descripcion: string;
  precio: number;
  categoriaId: number;
  estadoId: number;
  habilidadesIds: number[];
  caracteristicas: string[];
  requisitos: string[];
  hitos: HitoCreateDTO[];
  tiempoEntrega: number;
  unidadEntrega: string;
  desarrolladorId: number;
}