export interface CancelRequestDTO {
  id: number;
  proyectoId: number;
  requestedById: number;
  requestedByUsername: string;
  requestedToId: number;
  requestedToUsername: string;
  reason: string;
  status: string;
  requestedAt: string;
  respondedAt?: string; 
  responseReason?: string;
}