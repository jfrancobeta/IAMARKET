export interface Necesidad {
  id?: number;
  titulo: string;
  descripcion: string;
  categoria: string;
  presupuesto: number;
  companiaId: number;
  fechaLimite: string;
  requirements: string;
  estadoId: number;
  fechaCreacion?: string;
  fechaActualizacion?: string;
}
