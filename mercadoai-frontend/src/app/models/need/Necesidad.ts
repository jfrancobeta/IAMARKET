import { Estado } from "../Estado";
import { Habilidad } from "../Habilidad";
import { Usuario } from "../Usuario";

export class Necesidad {
  id?: number;
  titulo!: string;
  descripcion!: string;
  categoria!: string;
  presupuesto!: number;
  compania!: Usuario;
  fechaLimite!: string; // ISO date string
  skillsRequired!: Habilidad[];
  requirements!: string;
  expectedDeliverables!: string[];
  estado!: Estado;
  fechaCreacion!: string; // ISO date string
  fechaActualizacion!: string; // ISO date string
}