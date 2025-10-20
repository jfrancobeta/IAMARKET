import { HabilidadDTO } from "../Habilidad/HabilidadDTO";

export interface PerfilDesarrolladorDTO {
  id: number;
  habilidades: HabilidadDTO[];
  experiencia: number;
  portafolioURL: string;
  githubURL: string;
  linkedinURL: string;
}