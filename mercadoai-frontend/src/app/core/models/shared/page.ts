export interface Page<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  number: number; // página actual
  size: number;   // tamaño de página
}