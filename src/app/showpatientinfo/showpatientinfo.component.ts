import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {PatientinfoService} from './patientinfo.service';

@Component({
  selector: 'app-showpatientinfo',
  templateUrl: './showpatientinfo.component.html',
  styleUrls: ['./showpatientinfo.component.scss']
})
export class ShowpatientinfoComponent implements OnInit {

  public id:number;
  public lists:any;
  constructor(private service:PatientinfoService,private router:Router) {
    this.id=0;
    this.lists=[];
   }
  ngOnInit(): void {
  }

  getPatientRecord(){
    this.service.getPatientInfo(this.id).subscribe((data)=>{
      this.lists=[];
      if(data==null){
        this.router.navigateByUrl("/error");
      }
      
      this.lists.push(data);

    })
  }

  goHome(){
    this.router.navigateByUrl("/home");
  }

}
