package com.edubridge.Patient.DAO;

import java.util.List;

import com.edubridge.Patient.Model1.Patient;



public interface PatientDAO {
	int add_Patient_Details(Patient p);
	   List<Patient> get_All_Patient_Details();
	   Patient get_Patient_Details(String name);
	   int update_Patient_Details(Patient p);
	   int delete_Patient_Details(String name);
	   void delete_All_Patient_Details();
	   boolean checkModelExists(int id);
	
}
