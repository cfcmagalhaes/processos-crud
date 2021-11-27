import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Processo } from './../processo';
import { ProcessoService } from './../processo.service';

@Component({
  selector: 'app-processo-detail',
  templateUrl: './processo-detail.component.html',
  styleUrls: ['./processo-detail.component.css']
})
export class ProcessoDetailComponent implements OnInit {

  id: number = 0;
  processo: Processo = new Processo();
  constructor(private route:ActivatedRoute,
    private processoService: ProcessoService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.processo = new Processo();
    this.processoService.getProcessoById(this.id).subscribe( data => {
      this.processo = data;
    })
  }

}
