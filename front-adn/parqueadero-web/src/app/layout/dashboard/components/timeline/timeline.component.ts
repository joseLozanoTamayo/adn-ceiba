import { Component, OnInit } from '@angular/core';
import {petitionservice} from './../../../../shared/services/petitions';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.scss']
})
export class TimelineComponent implements OnInit {

  items=[1,2,3];
  constructor(public api:petitionservice) { }
  ngOnInit( ) {
    this.api.ejecutarGet("").then(
      res=>{
        //this.items=[]
        for (let item of res){
          // this.items=[...this.items,{
          //   "numero":item["numero"],
          //   "estado":item["estado"],
          //   "direccion":item["direccion"]
          // }];
        }
      }
    );
  }

}
