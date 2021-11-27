import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Processo } from '../processo';
import { ProcessoService } from './../processo.service';

@Component({
  selector: 'app-processo-list',
  templateUrl: './processo-list.component.html',
  styleUrls: ['./processo-list.component.css']
})
export class ProcessoListComponent implements OnInit {

  processos: Processo[] = [];

  constructor(private processoService: ProcessoService,
    private router: Router) { }

  ngOnInit(): void {
    this.getProcessos();
  }

  private getProcessos(){
    this.processoService.getProcessosList().subscribe(data => {
      this.processos = data;
    });
  }

  updateProcesso(id: number){
    this.router.navigate(['update-processo/', id]);
  }

  deleteProcesso(id: number){
    this.processoService.deleteProcesso(id).subscribe( data => {
      console.log(data);
      this.getProcessos();
    })
  }

  detailProcesso(id: number){
    this.router.navigate(['detail-processo/', id]);
  }

}
