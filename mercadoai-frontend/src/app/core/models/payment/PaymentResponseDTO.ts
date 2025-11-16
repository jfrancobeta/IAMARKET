import { PropuestaDTO } from "../Propuesta/PropuestaDTO";
import { SolucionDTO } from "../Solucion/SolucionDTO";

// PaymentResponseDTO.ts
export interface PaymentResponseDTO {
  id: number;
  paymentId: number;
  preferenceId: string;
  initPoint: string;
  status: string;
  amount: number;
  solucion: SolucionDTO | null ;
  propuesta: PropuestaDTO | null;
}