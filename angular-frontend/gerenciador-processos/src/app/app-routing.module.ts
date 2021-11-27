import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProcessoAddComponent } from './processo-add/processo-add.component';
import { ProcessoDetailComponent } from './processo-detail/processo-detail.component';
import { ProcessoListComponent } from './processo-list/processo-list.component';
import { ProcessoUpdateComponent } from './processo-update/processo-update.component';

const routes: Routes = [
  {path: 'list-processos', component: ProcessoListComponent},
  {path: 'add-processo', component: ProcessoAddComponent },
  {path: 'update-processo/:id', component: ProcessoUpdateComponent },
  {path: 'detail-processo/:id', component: ProcessoDetailComponent },
  {path: '', redirectTo: 'list-processos', pathMatch: 'full'}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
