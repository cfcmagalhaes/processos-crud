import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProcessoAddComponent } from './processo-add/processo-add.component';
import { ProcessoListComponent } from './processo-list/processo-list.component';

const routes: Routes = [
  {path: 'processo', component: ProcessoListComponent},
  {path: 'add', component: ProcessoAddComponent },
  {path: '', redirectTo: 'processo', pathMatch: 'full'}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
