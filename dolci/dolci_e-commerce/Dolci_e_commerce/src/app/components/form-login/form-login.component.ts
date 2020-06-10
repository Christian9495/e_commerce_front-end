import { Component, OnInit } from '@angular/core';
import { MainServiceService } from 'src/app/services/main-service.service';
import { Cliente } from 'src/app/classes/cliente';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.css']
})
export class FormLoginComponent implements OnInit {

  constructor(private mainService: MainServiceService) { }
  public cliente: Cliente;
  public visibile = true;
  ngOnInit(): void {
  }

  cercaCliente(username: String){

    this.mainService.cercaCliente(username).subscribe((cliente) => {
      this.cliente = cliente;
      console.log(this.cliente);
      
    });
    
    
  }

}
