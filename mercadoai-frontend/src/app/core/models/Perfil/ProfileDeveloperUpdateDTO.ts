import { HabilidadCreateDTO } from "../Habilidad/HabilidadCreateDTO";

export interface ProfileDeveloperUpdateDTO {
  portafolioURL: string;
  githubURL: string;
  linkedinURL: string;
  habilidad: HabilidadCreateDTO[];
  experiencia: number;
}