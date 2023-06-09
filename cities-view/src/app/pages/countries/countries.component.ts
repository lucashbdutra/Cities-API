import { HttpParams } from '@angular/common/http';
import { Component } from '@angular/core';
import { Country } from 'src/app/interfaces/country';
import { CountryDto } from 'src/app/interfaces/country-dto';
import { CountriesService } from 'src/app/services/countries.service';

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css']
})
export class CountriesComponent {
  totalPages: number = 0;
  totalElements: number = 0;
  pageNumber: number = 0;
  size: number = 0;

  countries: Country[] = [];

  searchTerm: string = '';
  loading: boolean = false;

  constructor( private countriesService: CountriesService ){
    this.listar();
  }

  listar(page: number = 0, size: number = 10){
    this.loading = true;

    this.countriesService.getAll(page, size).subscribe((countryDTO: CountryDto) => {
      this.countries = countryDTO.countries;
      this.totalPages = countryDTO.totalPages
      this.totalElements = countryDTO.totalElements;
      this.pageNumber = countryDTO.pageNumber;
      this.size = countryDTO.size;
      this.loading = false;
    });
  }

  pageChanged(event: any): void {
    this.listar(event);
  }

  handleItem(event: Event){
    const target = event.target as HTMLInputElement
    const value = target.value
    this.searchTerm = value as string;
  }

  search(){
    let params = new HttpParams();
    params = params.set('searchTerm', this.searchTerm)
    this.countriesService.search(params).subscribe((country: Country) => {
      this.countries = Array.of(country);
    })
  }

}
