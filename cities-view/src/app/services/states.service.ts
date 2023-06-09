import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StateDto } from '../interfaces/state-dto';

@Injectable({
  providedIn: 'root'
})
export class StatesService {


  api = "http://localhost:8080/api/v1/states";
  errorHandler:any = null;

  constructor(
    private http: HttpClient
  ) { }

  getAll(page: number = 0, size: number = 10): Observable<StateDto>{
    return this.http.get<StateDto>(`${this.api}?page=${page}&size=${size}&sort=asc`);
}

  search(params: HttpParams): Observable<any>{
    return this.http.get(`${this.api}/searchState`, {params});
  }
}
