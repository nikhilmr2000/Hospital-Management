package com.hospital.HospitalManagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.HospitalManagement.Controller.HospitalManagementController;
import com.hospital.HospitalManagement.Entity.Doctor;
import com.hospital.HospitalManagement.Entity.Patient;
import com.hospital.HospitalManagement.Service.HospitalManagementService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=HospitalManagementController.class)
public class HospitalTest {
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private HospitalManagementService service;
	
	//Test Doctor While Saving
	
		@Test
		public void DoctorSaveTest() throws Exception{

			Doctor doctor=new Doctor();
			doctor.setName("Nikhil");
			doctor.setAge(22);
			doctor.setGender("Male");
			doctor.setField("General Medicine");
			
			String input = this.mapToJson(doctor);
			
			String URI = "/addDoctor";
			
			Mockito.when(service.addDoctorDetails(Mockito.any(Doctor.class))).thenReturn(doctor);
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post(URI)
					.accept(MediaType.APPLICATION_JSON).content(input)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mock.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			
			String output = response.getContentAsString();
			
			assertEquals(output,input);
		}
	
	//Test for Get Doctor By Name
	
	@Test
	public void testDoctor() throws Exception{
		Doctor doctor=new Doctor();
		doctor.setName("Nikhil");
		doctor.setAge(22);
		doctor.setGender("Male");
		doctor.setField("Ayurvedic");

		String input=this.mapToJson(doctor);
		
		String uri="/getDoctor/Nikhil";
		
		Mockito.when(service.getParticularDoctor(Mockito.anyString())).thenReturn(doctor);
		
		RequestBuilder request=MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		
		MvcResult res=mock.perform(request).andReturn();
		
		String output=res.getResponse().getContentAsString();
		
		assertEquals(output,input);	
		
	}
	
	//Test Patient While Saving
	
		@Test
		public void PatientSaveTest() throws Exception{
			
			Doctor doctor=new Doctor();
			Patient patient=new Patient();
			patient.setName("Singh");
			patient.setAge(22);
			patient.setDate(date);
			doctor.setName("Raju");
			doctor.setAge(23);
			doctor.setGender("Male");
			doctor.setField("General Medicine");
			patient.setDoctor_id(doctor);
			patient.setPrescription("Fever");
			
			String input = this.mapToJson(patient);
			
			String URI = "/addPatient";
			
			Mockito.when(service.savePatient(Mockito.any(Patient.class))).thenReturn(patient);
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post(URI)
					.accept(MediaType.APPLICATION_JSON).content(input)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mock.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			
			String output = response.getContentAsString();
			
			assertEquals(output,input);
		}
	
	@DateTimeFormat(pattern="dd-mm-yyyy")
	private Date date;
	
	//Test for Get Patient Detail By Id
	
	@Test
	public void testPatient() throws Exception{
		
		Doctor doctor=new Doctor();
		Patient patient=new Patient();
		patient.setName("Singh");
		patient.setAge(22);
		patient.setDate(date);
		doctor.setName("Raju");
		doctor.setAge(23);
		doctor.setGender("Male");
		doctor.setField("General Medicine");
		patient.setDoctor_id(doctor);
		patient.setPrescription("Fever");
		
		String input=this.mapToJson(patient);
		
		String uri="/getPatientById/1";
		
		Mockito.when(service.getPatientById(Mockito.anyLong())).thenReturn(patient);
		
		RequestBuilder request=MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		
		MvcResult res=mock.perform(request).andReturn();
		
		String output=res.getResponse().getContentAsString();
		
	
		assertEquals(output,input);	
		
		
	}
	
	
	private String mapToJson(Object obj) throws JsonProcessingException{
		ObjectMapper map=new ObjectMapper();
		return map.writeValueAsString(obj);
	}
	
	
}
