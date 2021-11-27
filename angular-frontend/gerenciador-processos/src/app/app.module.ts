import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProcessoAddComponent } from './processo-add/processo-add.component';
import { ProcessoListComponent } from './processo-list/processo-list.component';
import { ProcessoUpdateComponent } from './processo-update/processo-update.component';
import { ProcessoDetailComponent } from './processo-detail/processo-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    ProcessoListComponent,
    ProcessoAddComponent,
    ProcessoUpdateComponent,
    ProcessoDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
