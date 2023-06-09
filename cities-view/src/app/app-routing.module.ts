import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CitiesComponent } from './pages/cities/cities.component';
import { CountriesComponent } from './pages/countries/countries.component';
import { StatesComponent } from './pages/states/states.component';

const routes: Routes = [
  {
    path: 'cidades', component:CitiesComponent
  },
  {
    path: 'estados', component:StatesComponent
  },
  {
    path: 'paises', component:CountriesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
