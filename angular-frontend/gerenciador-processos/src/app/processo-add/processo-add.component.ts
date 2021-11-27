import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Processo } from '../processo';
import { ProcessoService } from './../processo.service';

@Component({
  selector: 'app-processo-add',
  templateUrl: './processo-add.component.html',
  styleUrls: ['./processo-add.component.css']
})
export class ProcessoAddComponent implements OnInit {

  processo: Processo = new Processo();

  constructor(private processoService: ProcessoService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveProcesso(){
    this.processoService.addProcesso(this.processo).subscribe( data => {
      console.log(data);
      this.goToProcessoList();
    },
    error => console.log(error));
  }

  goToProcessoList(){
    this.router.navigate(['/list-processos']);
  }

  onSubmit(){
    console.log(this.processo);
    this.saveProcesso();
  }

}
