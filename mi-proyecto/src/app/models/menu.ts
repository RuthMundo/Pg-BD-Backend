import { Opcion } from './opcion'

export interface Menu {
  idMenu: number;
  nombreMenu: string;
  orden: number;
  idModulo: number;
  listOpcion: Opcion[];
}
