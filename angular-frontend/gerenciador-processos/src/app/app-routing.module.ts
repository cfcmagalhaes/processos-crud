import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProcessoAddComponent } from './processo-add/processo-add.component';
import { ProcessoDetailComponent } from './processo-detail/processo-detail.component';
import { ProcessoListComponent } from './processo-list/processo-list.component';
import { ProcessoUpdateComponent } from './processo-update/processo-update.component';

const routes: Routes = [
  {path: 'processo', component: ProcessoListComponent},
  {path: 'processo/add', component: ProcessoAddComponent },
  {path: 'processo/update/:id', component: ProcessoUpdateComponent },
  {path: 'processo/find/:id', component: ProcessoDetailComponent },
  {path: '', redirectTo: 'processo', pathMatch: 'full'}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
