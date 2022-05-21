import { Component, OnInit ,Input} from '@angular/core';
import {ShowdoctorService} from './showdoctor.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

interface Doctor{
  name:string,age:number,gender:String,field:string,attendees:number
}
@Component({
  selector: 'app-showdoctorinfo',
  templateUrl: './showdoctorinfo.component.html',
  styleUrls: ['./showdoctorinfo.component.scss']
})
export class ShowdoctorinfoComponent implements OnInit {

  @Input() public doctorName:string=""; //Getting  Doctor Name
  private doctor:Doctor;
  lists:any;

  doctorlist:any=this.showdoctor.GetEveryDoctorDetails();

  constructor(private showdoctor:ShowdoctorService,private router:Router) {
    this.doctor={} as Doctor;
    this.lists=[];
   }

  ngOnInit(): void {
  }
  
  showDoctorSelected(){
    this.showdoctor.GetAllDoctorDetails(this.doctorName).subscribe((data)=>{
      this.lists=[];
      this.lists.push(data);
      console.log(this.lists);
    });
  }

  goHome(){
    this.router.navigateByUrl("/home");
  }

}
