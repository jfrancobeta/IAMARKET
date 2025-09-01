import { CategoriaDTO } from "../Categoria/CategoriaDTO";
import { EstadoDTO } from "../Estado/EstadoDTO";
import { HabilidadDTO } from "../Habilidad/HabilidadDTO";
import { Usuario } from "../Usuario/Usuario";
import { UsuarioDTO } from "../Usuario/UsuarioDTO";

export interface NecesidadDTO {
  id?: number; // Opcional si es para crear, requerido si es para editar
  titulo: string;
  descripcion: string;
  categoria: CategoriaDTO;
  presupuesto: number; // o string si tu backend lo envía como texto
  compania: UsuarioDTO; // Asegúrate de tener esta interfaz
  fechaLimite: string; // o Date si lo conviertes después
  skillsRequired: HabilidadDTO[];
  requirements: string[];
  expectedDeliverables: string[];
  estado: EstadoDTO;
  fechaCreacion?: string; // Opcional si solo lo devuelve el backend
  fechaActualizacion?: string; // Opcional si solo lo devuelve el backend
}