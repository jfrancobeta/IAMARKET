import { UsuarioCalificacionDTO } from "../Usuario/UsuarioCalificacionDTO";

export interface PropuestaUserDetailsDTO {
  id: number;
  necesidad: number; // id de la necesidad
  desarrollador: UsuarioCalificacionDTO;
  precio: number; // o string si tu backend lo envía como texto
  entrega: string;
  descripcion: string;
  estado: string;
  fechaCreacion: string; // o Date si lo conviertes después
}