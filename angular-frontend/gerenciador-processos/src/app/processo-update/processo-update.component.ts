import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { ProcessoService } from '../processo.service';
import { Processo } from './../processo';

@Component({
  selector: 'app-processo-update',
  templateUrl: './processo-update.component.html',
  styleUrls: ['./processo-update.component.css']
})
export class ProcessoUpdateComponent implements OnInit {

  id: number = 0;
  processo: Processo = new Processo();

  constructor(private processoService: ProcessoService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.processoService.getProcessoById(this.id).subscribe( data => {
      this.processo = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.processoService.updateProcesso(this.id, this.processo).subscribe(data => {
      this.goToProcessoList();
    }, error => console.log(error));
  }

  goToProcessoList(){
    this.router.navigate(['/list-processos']);
  }

}
