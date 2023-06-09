import { HttpParams } from '@angular/common/http';
import { Component } from '@angular/core';
import { State } from 'src/app/interfaces/state';
import { StateDto } from 'src/app/interfaces/state-dto';
import { StatesService } from 'src/app/services/states.service';

@Component({
  selector: 'app-states',
  templateUrl: './states.component.html',
  styleUrls: ['./states.component.css']
})
export class StatesComponent {

  totalPages: number = 0;
  totalElements: number = 0;
  pageNumber: number = 0;
  size: number = 0;

  states: State[] = [];

  searchTerm: string = '';
  loading: boolean = false;

  constructor( private statesService: StatesService ){
    this.listar();
  }

  listar(page: number = 0, size: number = 10){
    this.loading = true;

    this.statesService.getAll(page, size).subscribe((stateDTO: StateDto) => {
      this.states = stateDTO.states;
      this.totalPages = stateDTO.totalPages;
      this.totalElements = stateDTO.totalElements;
      this.pageNumber = stateDTO.pageNumber;
      this.size = stateDTO.size;

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
    this.statesService.search(params).subscribe((state: State) => {
      this.states = Array.of(state);
    })
  }


}
