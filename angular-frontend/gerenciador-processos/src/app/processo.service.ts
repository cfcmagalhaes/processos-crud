import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Processo } from './processo';

@Injectable({
  providedIn: 'root'
})
export class ProcessoService {

  private baseURL = "http://localhost:8080/processo";

  constructor(private httpClient: HttpClient) { }

  getProcessosList(): Observable<Processo[]>{
    return this.httpClient.get<Processo[]>(`${this.baseURL}`);
  }

  addProcesso(processo: Processo): Observable<Object>{
    return this.httpClient.post(`${this.baseURL + '/add'}`, processo);
  }
}
