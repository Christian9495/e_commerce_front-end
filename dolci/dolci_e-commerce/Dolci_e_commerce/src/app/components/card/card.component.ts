import { Component, OnInit, Input } from '@angular/core';
import { Dolce } from 'src/app/classes/dolce';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  @Input('dolce') dolce: Dolce;
  constructor() { }

  ngOnInit(): void {
  }

}
