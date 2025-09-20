export interface SolucionCreateDTO {
  titulo: string;
  descripcion: string;
  precio: number;
  categoriaId: number;
  estadoId: number;
  habilidadesIds: number[];
  caracteristicas: string[];
  requisitos: string[];
  tiempoEntrega: number;
  unidadEntrega: string;
  desarrolladorId: number;
}