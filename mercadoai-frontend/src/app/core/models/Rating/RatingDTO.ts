import { ProyectoDTO } from "../Proyecto/ProyectoDTO";
import { UsuarioDTO } from "../Usuario/UsuarioDTO";

export interface RatingDTO {
    id: number;
    usuario: UsuarioDTO;
    usuarioCalificado: UsuarioDTO;
    proyecto: ProyectoDTO;
    calificacion: number;
    comentario: string;
    estado: string;
    fechaCalificacion: string; // ISO date string
}