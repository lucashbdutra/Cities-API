import { City } from "./city";

export interface CityDTO {
  cities: City[];
  totalPages: number,
  totalElements: number,
  pageNumber: number,
  size: number;
}
