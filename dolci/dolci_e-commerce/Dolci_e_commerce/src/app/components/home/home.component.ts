import { Component, OnInit } from '@angular/core';
import { MainServiceService } from 'src/app/services/main-service.service';
import { Dolce } from 'src/app/classes/dolce';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public dolci: Dolce[];

  constructor(private mainService: MainServiceService) { }

  ngOnInit(): void {
    this.mainService.getDolci().subscribe((dolci)=>{
      this.dolci = dolci;
      console.log(this.dolci)
    })
  }



}
