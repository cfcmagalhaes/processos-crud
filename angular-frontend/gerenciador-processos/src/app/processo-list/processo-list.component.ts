import { Component, OnInit } from '@angular/core';

import { Processo } from '../processo';
import { ProcessoService } from './../processo.service';

@Component({
  selector: 'app-processo-list',
  templateUrl: './processo-list.component.html',
  styleUrls: ['./processo-list.component.css']
})
export class ProcessoListComponent implements OnInit {

  processos: Processo[] = [];

  constructor(private processoService: ProcessoService) { }

  ngOnInit(): void {
    this.getProcessos();
  }

  private getProcessos(){
    this.processoService.getProcessosList().subscribe(data => {
      this.processos = data;
    });
  }

}
