import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Patient} from './Patient';
@Injectable({
  providedIn: 'root'
})
export class PatientinfoService {

  constructor(private http:HttpClient) { }

  getPatientInfo(id:number):Observable<Patient>{
    return this.http.get<Patient>("http://localhost:7070/getPatientById/"+id);
  }
}
