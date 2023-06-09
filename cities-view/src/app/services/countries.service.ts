import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CountryDto } from '../interfaces/country-dto';

@Injectable({
  providedIn: 'root'
})
export class CountriesService {

  api = "http://localhost:8080/api/v1/countries";
  errorHandler:any = null;

  constructor(
    private http: HttpClient
  ) { }

  getAll(page: number = 0, size: number = 10): Observable<CountryDto>{
    return this.http.get<CountryDto>(`${this.api}?page=${page}&size=${size}&sort=asc`);
}

  search(params: HttpParams): Observable<any>{
    return this.http.get(`${this.api}/searchCountry`, {params});
  }
}
