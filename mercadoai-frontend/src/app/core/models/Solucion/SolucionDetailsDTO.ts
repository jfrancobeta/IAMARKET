import { CategoriaDTO } from "../Categoria/CategoriaDTO";
import { EstadoDTO } from "../Estado/EstadoDTO";
import { HabilidadDTO } from "../Habilidad/HabilidadDTO";
import { HitoDTO } from "../Hito/HitoDTO";
import { UsuarioDTO } from "../Usuario/UsuarioDTO";

export interface SolucionDetailsDTO {
    id: number;
    titulo: string;
    descripcion: string;
    precio: number;
    vistas: number;
    pedidos: number;
    categoria: CategoriaDTO;
    estado: EstadoDTO;
    habilidades: HabilidadDTO[];
    caracteristicas: string[];
    requisitos: string[];
    hitos: HitoDTO[];
    tiempoEntrega: number;
    unidadEntrega: UnidadEntrega;
    fechaCreacion: string; 
    fechaActualizacion: string;
    desarrollador: UsuarioDTO;
}

export enum UnidadEntrega {
  Dias = 'DIAS',
  Meses = 'MESES',
  Semanas = 'SEMANAS'
}