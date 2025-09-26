import { HitoCreateDTO } from "../Hito/HitoCreateDTO";

export interface NecesidadCreateDTO {
  titulo: string;
  descripcion: string;
  categoria: number;
  presupuesto: number; // o string si tu backend lo envía como texto
  companiaId: number; // sin ñ
  fechaLimite: string; // o Date si lo conviertes después
  skillsRequiredIds: number[];
  requirements?: string[];
  hitos: HitoCreateDTO[];
  estadoId: number;
}