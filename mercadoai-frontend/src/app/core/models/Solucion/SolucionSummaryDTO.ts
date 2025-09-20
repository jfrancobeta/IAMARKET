export interface SolucionSummaryDTO {
  id: number;
  titulo: string;
  estadoNombre: string;
  categoriaNombre: string;
  descripcion: string;
  precio: number;
  tiempoEntrega: number;
  unidadEntrega: string;
  habilidades: string[];
  vistas: number;
}