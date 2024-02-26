import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RoutesEnum } from './enums/routes-enum';
import { BookListComponent } from './components/book/book-list/book-list.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: RoutesEnum.HOME
  },
  {
    path: RoutesEnum.HOME,
    component: BookListComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
