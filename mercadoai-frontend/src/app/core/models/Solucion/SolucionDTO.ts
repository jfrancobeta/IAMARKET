import { HitoDTO } from "../Hito/HitoDTO";

export interface SolucionDTO {
  id: number;
  titulo: string;
  descripcion: string;
  precio: number;
  vistas: number;
  pedidos: number;
  categoriaId: number;
  estadoId: number;
  habilidadesIds: number[];
  caracteristicas: string[];
  requisitos: string[];
  hitos: HitoDTO[];
  tiempoEntrega: number;
  unidadEntrega: string; 
  fechaCreacion: string; 
  fechaActualizacion: string;
  desarrolladorId: number;
}