import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MainServiceService {

  private endpointLogin: string ="http://localhost:8080/pasticceria/cercaCliente";
  private endpointDolci: string ="http://localhost:8080/pasticceria/allDolci";


  constructor( private httpClient: HttpClient) { }

  public cercaCliente(username: String): Observable<any> {
    return this.httpClient.post(this.endpointLogin, username, {responseType: 'text' as 'json'})
  }

  public getDolci(): Observable<any>{
    return this.httpClient.get(this.endpointDolci);    
  }
}
