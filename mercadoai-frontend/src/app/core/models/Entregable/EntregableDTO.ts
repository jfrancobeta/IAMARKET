export interface EntregableDTO {
  id: number;
  nombreArchivo: string;
  url: string | null;
  fechaEntrega: string | null; // ISO date string
}