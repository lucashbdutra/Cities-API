import { Country } from "./country";

export interface CountryDto {
  countries: Country[];
  totalPages: number,
  totalElements: number,
  pageNumber: number,
  size: number;
}
