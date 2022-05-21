import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DoctorregisterComponent } from './doctorregister/doctorregister.component';
import { ShowdoctorinfoComponent } from './showdoctorinfo/showdoctorinfo.component';
import { PatientregisterComponent } from './patientregister/patientregister.component';
import { ShowpatientinfoComponent } from './showpatientinfo/showpatientinfo.component';
import { HomeComponent } from './home/home.component';
import { ErrorpageComponent } from './errorpage/errorpage.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    DoctorregisterComponent,
    ShowdoctorinfoComponent,
    PatientregisterComponent,
    ShowpatientinfoComponent,
    HomeComponent,
    ErrorpageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
