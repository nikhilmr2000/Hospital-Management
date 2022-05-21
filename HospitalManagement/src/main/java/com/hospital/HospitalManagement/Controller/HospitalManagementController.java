package com.hospital.HospitalManagement.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.HospitalManagement.Entity.Doctor;
import com.hospital.HospitalManagement.Entity.Patient;
import com.hospital.HospitalManagement.Service.HospitalManagementService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HospitalManagementController {
	
	@Autowired
	private HospitalManagementService service;
	
	//ADD DOCTOR DETAILS
	
	@PostMapping("/addDoctor")
	public Doctor addDetailsOfDoctor(@RequestBody Doctor doctor) {
		Doctor postDoctor=service.addDoctorDetails(doctor);
		return postDoctor;
	}
	
	//GET DOCTOR DETAILS
	
	@GetMapping("/getAllDoctor")
	public List<Doctor> getDoctorDetails(){
		return service.getAllDoctorDetails();
	}
	
	//GET A PARTICULAR DOCTOR DETAIL
	
	@GetMapping("/getDoctor/{name}")
	public Doctor getOneDoctor(@PathVariable String name) {
		return service.getParticularDoctor(name);
	}
	
	
	//ADD PATIENT
	@PostMapping("/addPatient")
	public Patient addPatientDetaild(@RequestBody Patient patient) {
		System.out.println(patient);
		Patient storedPatient=service.savePatient(patient);
		return storedPatient;
	}
	
	//GET PATIENT DETAILS
	@GetMapping("/getPatient")
	public List<Patient> getPatientDetails(){
		return service.getAllPatient();
	}
	
	//GET PATIENT BY ID
	@GetMapping("/getPatientById/{id}")
	public Patient getOnePatient(@PathVariable long id) {
		return service.getPatientById(id);
	}
	
		
	
}
