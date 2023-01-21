import { Component } from '@angular/core';
import { City } from 'src/app/interfaces/city';
import { CityDTO } from 'src/app/interfaces/city-dto';
import { CitiesService } from 'src/app/services/cities.service';

@Component({
  selector: 'app-cities',
  templateUrl: './cities.component.html',
  styleUrls: ['./cities.component.css']
})
export class CitiesComponent {

  totalPages: number = 0;
  totalElements: number = 0;
  pageNumber: number = 0;
  size: number = 0;

  cities:City[] = []

  constructor( private cityService: CitiesService ){
    this.listar();
  }

  listar(page: number = 0, size: number = 10){

    this.cityService.getAll(page, size).subscribe((cityDTO: CityDTO) => {
      this.cities = cityDTO.cities;
      this.totalPages = cityDTO.totalPages;
      this.totalElements = cityDTO.totalElements;
      this.pageNumber = cityDTO.pageNumber;
      this.size = cityDTO.size;
      console.log(cityDTO.cities)
    });
  }

  pageChanged(event: any): void {
    this.listar(event);
  }

  // getRequestParams(searchTitle: string, page: number, pageSize:number): any {
  //   // tslint:disable-next-line:prefer-const
  //   let params = {'searchTerm': '', 'page': 0, 'size':10};

  //   if (searchTitle) {
  //     params[`searchTerm`] = searchTitle;
  //   }

  //   if (page) {
  //     params[`page`] = page - 1;
  //   }

  //   if (pageSize) {
  //     params[`size`] = pageSize;
  //   }

  //   return params;
  // }


  handleItem(event: Event){
    const target = event.target as HTMLInputElement
    const value = target.value
    // this.name = value as string;
  }
}
