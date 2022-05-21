import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorregisterComponent } from './doctorregister/doctorregister.component';
import { ShowdoctorinfoComponent } from './showdoctorinfo/showdoctorinfo.component';
import { PatientregisterComponent } from './patientregister/patientregister.component';
import { ShowpatientinfoComponent } from './showpatientinfo/showpatientinfo.component';
import { HomeComponent } from './home/home.component';
import { ErrorpageComponent } from './errorpage/errorpage.component';

const routes: Routes = [
  {path:'addDoctor',component:DoctorregisterComponent},
  {path:'getAllDoctor',component:ShowdoctorinfoComponent},
  {path:'addPatient',component:PatientregisterComponent},
  {path:'getAllPatient',component:ShowpatientinfoComponent},
  {path:'home',component:HomeComponent},
  {path:'error',component:ErrorpageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
