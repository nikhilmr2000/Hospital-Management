import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
interface Doctor{
  name:string,age:number,gender:String,field:string
}
@Injectable({
  providedIn: 'root'
})
export class ShowdoctorService {
  
  constructor(private httpClient:HttpClient) { 
    
  }
  GetAllDoctorDetails(doctorName:string):Observable<any>{
    return this.httpClient.get<any>("http://localhost:7070/getDoctor/"+doctorName);
  }

  GetEveryDoctorDetails():any{
    return this.httpClient.get<any>("http://localhost:7070/getAllDoctor");
  }

}
