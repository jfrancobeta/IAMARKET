import { ProyectoDTO } from "../Proyecto/ProyectoDTO";
import { UsuarioDTO } from "../Usuario/UsuarioDTO";

export interface PendingRatingDTO {
    id: number;
    proyecto: ProyectoDTO;
    usuarioCalificado: UsuarioDTO;
    estado: string;
}