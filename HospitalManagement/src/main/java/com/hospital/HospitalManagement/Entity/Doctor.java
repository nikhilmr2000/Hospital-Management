package com.hospital.HospitalManagement.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Doctor")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="specialistField")
	private String field; 
	
	@Column(name="attendees")
	private int attendees;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY,mappedBy="doctor_id")
	private List<Patient> patients=new ArrayList<>();

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String name, int age, String gender, String field) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.field = field;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}
	

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Patient patients) {
		this.patients.add(patients);
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	public int getAttendees() {
		return attendees;
	}

	public void setAttendees(int attendees) {
		this.attendees = attendees;
	}


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", field=" + field +", Patients= " +patients+ "]";
	}
	
	
}
