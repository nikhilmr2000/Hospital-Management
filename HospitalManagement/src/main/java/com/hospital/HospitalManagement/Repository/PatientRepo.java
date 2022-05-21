package com.hospital.HospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.HospitalManagement.Entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long>{

}
