package com.hospital.HospitalManagement.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hospital.HospitalManagement.Entity.Doctor;
import com.hospital.HospitalManagement.Entity.Patient;
import com.hospital.HospitalManagement.Repository.DoctorRepo;
import com.hospital.HospitalManagement.Repository.PatientRepo;

@Service
public class HospitalManagementService {
	@Autowired
	private DoctorRepo docrepo;
	@Autowired
	private PatientRepo patientrepo;
	
	//POST DOCTOR DETAILS
	public Doctor addDoctorDetails(Doctor doctor) {
		Doctor savedDetails=docrepo.save(doctor);
		return savedDetails;
	}
	
	//GET ALL DOCTOR NAMES
	public List<String> getAllDoctorName(){
		List<Doctor> listDoctors=docrepo.findAll();
		List<String> doctornames=new ArrayList<String>();
		for(Doctor doctor : listDoctors) {
			doctornames.add(doctor.getName());
		}
		return doctornames;
	}
	
	
	//ALSO USED IN PATIENT FOR GETTING DOCTOR DETAILS USING DROPDOWN
	//GET PARTICULAR DOCTOR DETAILS
	public Doctor getParticularDoctor(String name) {
		List<Doctor> doctorlist=docrepo.findAll();
		for(Doctor doctor : doctorlist) {
			if(doctor.getName().equals(name)) {
				return doctor;
			}
		}
		return null;
	}
	
	
	//GET ALL DOCTOR DETAILS
	public List<Doctor> getAllDoctorDetails() {
		return docrepo.findAll();
	}
	
	//SAVE PATIENT RECORDS
	public Patient savePatient(Patient patient) {
		List<Doctor> doctor=docrepo.findAll();
		if(patient!=null) {
			for(Doctor doc :doctor) {
				if(patient.getDoctor_id().getId()==doc.getId()) {
					doc.setAttendees(doc.getAttendees()+1);
				}
			}
			Patient addedPatient=patientrepo.save(patient);
			return addedPatient;
		}
		return null;
	}
	
	//GET PATIENT RECORDS
	public List<Patient> getAllPatient(){
		return patientrepo.findAll();
	}
	
	//GET PATIENT RECORD BY ID
	public Patient getPatientById(long id) {
		List<Patient> allPatients=patientrepo.findAll();
		for(Patient patient: allPatients) {
			if(patient.getId()==id) {
				return patient;
			}
		}
		return null;
	}
	
	
	
}
