import { Component, OnInit,Input } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from './register.service';
interface Doctor{
  name:string,
  age:number,
  gender:string,
  field:string
}
@Component({
  selector: 'app-doctorregister',
  templateUrl: './doctorregister.component.html',
  styleUrls: ['./doctorregister.component.scss']
})
export class DoctorregisterComponent implements OnInit {
  @Input()  doctor:Doctor;
  constructor(private router:Router,private register:RegisterService) {
    this.doctor={} as Doctor;
   }

  ngOnInit(): void {
  }

  addDoctor(){
    console.log(this.doctor);
      if(this.doctor.name!=null && this.doctor.age!=null && this.doctor.gender!=null && this.doctor.field!=null){
          this.register.postDoctorDetails(this.doctor).subscribe((data)=>{
          this.router.navigateByUrl("/home");
          alert("Doctor Added");
        });
      }
      else{
        alert("Fill All Doctor Details");
      }
  }

}
