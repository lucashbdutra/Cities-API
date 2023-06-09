import { State } from "./state";

export interface StateDto {
  states: State[];
  totalPages: number,
  totalElements: number,
  pageNumber: number,
  size: number;
}
