import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap } from 'rxjs';
import { City } from '../interfaces/city';
import { CityDTO } from '../interfaces/city-dto';

@Injectable({
  providedIn: 'root'
})
export class CitiesService {

  api = "http://localhost:8080/api/v1/cities";
  errorHandler:any = null;

  constructor(
    private http: HttpClient
  ) { }

  getAll(page: number = 0, size: number = 10): Observable<CityDTO>{
    return this.http.get<CityDTO>(`${this.api}?page=${page}&size=${size}&sort=asc`);
}

  search(params: HttpParams): Observable<any>{
    return this.http.get(`${this.api}/search`, {params});
  }
}
