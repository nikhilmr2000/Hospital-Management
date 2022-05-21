import { Injectable } from '@angular/core';
import {Patient} from './Patient';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})


export class PatientService {
  patient:Patient;
  constructor(private httpClient:HttpClient) { 
    this.patient={} as Patient;
  }

  getAllDoctorsNames():Observable<any>{
    return this.httpClient.get<any>("http://localhost:7070/getAllDoctor");
  }

  postAllPatients(details:Patient):Observable<Patient>{
    return this.httpClient.post<Patient>("http://localhost:7070/addPatient",details);
  }

}
