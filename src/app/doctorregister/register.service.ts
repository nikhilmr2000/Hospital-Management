import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
interface Doctor{
  name:string,
  age:number,
  gender:string,
  field:string
}
@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  doctor:Doctor;
  constructor(private httpClient:HttpClient) { 
    this.doctor={} as Doctor;
  }

  postDoctorDetails(doctorParam:Doctor):Observable<Doctor>{
    return this.httpClient.post<Doctor>("http://localhost:7070/addDoctor",doctorParam);
  }

}
