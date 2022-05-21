import { Component, OnInit ,Input} from '@angular/core';
import {PatientService} from './patient.service';
import {Patient} from './Patient';
import { Router } from '@angular/router';

@Component({
  selector: 'app-patientregister',
  templateUrl: './patientregister.component.html',
  styleUrls: ['./patientregister.component.scss']
})
export class PatientregisterComponent implements OnInit {
  @Input() patient:Patient;
  
  lists:any;
  values:number;
  constructor(private patientService:PatientService,private router:Router) { 
    this.patient ={} as Patient;
    this.lists=[];

    this.values=0;

  }

  ngOnInit(): void {
    this.getDet();
  }

  postPatients(){
    if(this.patient.name!=null && this.patient.age!=null && this.patient.date!=null && this.patient.doctor_id!=null && this.patient.prescription!=null){
        this.patientService.postAllPatients(this.patient).subscribe((data)=>{
          this.router.navigateByUrl("/home");
        alert("Patient Added");
      });
    }
    else{
      alert("Fill All Patient Details");
    }
  }

  getDet(){
      this.patientService.getAllDoctorsNames().subscribe((data)=>{
        this.lists=data;
      });
  }

}
