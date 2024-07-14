package com.edubridge.Patient;

import java.util.List;
import java.util.Scanner;

import com.edubridge.Patient.Model1.Patient;
import com.edubridge.Patient.DAO.PatientDAO;
import com.edubridge.Patient.DAO.PatientDAOIMPL;

public class App 
{
    public static void main( String[] args ) {
    	PatientDAO dao= new PatientDAOIMPL();
    	Scanner in=new Scanner(System.in);
    	while(true) {
    		System.out.println("Patient APP");
    		System.out.println("-----------");
    		System.out.println("1.ADD Patient_DETAILS");
    		System.out.println("2.VIEW ALL Patient_DETAILS");
    		System.out.println("3.SEARCH Patient_DETAIL");
    		System.out.println("4.UPDATE Patient_DETAILS");
    		System.out.println("5.DELETE Patient_DETAILS");
    		System.out.println("6.DELETE ALL Patient_DETAILS");
    		System.out.println("0. EXIT");
    		System.out.println("PLEASE CHOOSE OPTION:");
    		
    		int option =in.nextInt();
    		switch (option) {
			case 1:
				System.out.println("Please enter Patient Name:");
				String name=in.next();
				
				System.out.println("Please enter Patient Wardno:");
				int wardno=in.nextInt();
				
				System.out.println("Please enter Patient Disease:");
				String disease =in.next();
				
				System.out.println("Please enter Patient Mobile:");
				long mobile=in.nextLong();
				
				Patient new_Patient_DETAILS=new Patient();
				new_Patient_DETAILS.setName(name);
				new_Patient_DETAILS.setWardno(wardno);
				new_Patient_DETAILS.setDisease(disease);
				new_Patient_DETAILS.setMobile(mobile);
				
				int status=dao.add_Patient_Details(new_Patient_DETAILS);
				if(status>=1) {
					System.out.println("New Details  are Saved!!!");
				}else {
					System.out.println("Given Details are not saved!!!");
				}
				break;
			case 2:
				List<Patient> patientlist=dao.get_All_Patient_Details();
				if(patientlist.size() !=0) {
					for(Patient patient : patientlist) {
						System.out.println(patient.getId()+"\t"+patient.getName()+"\t"+patient.getWardno()
						+"\t"+patient.getDisease()+"\t"+patient.getMobile());
					}
				}else {
					System.out.println("No Details are Found");
				}
				break;
			case 3:
				 System.out.println("Please enter the name of the Patient Name to search:");
                 String searchName = in.next();
                 Patient patient = (Patient) dao.get_Patient_Details(searchName);
                 if (patient !=null) {
                     System.out.println(patient.getId() + "\t" + patient.getName() + "\t" + patient.getWardno() + "\t" + patient.getDisease()+"\t"+patient.getMobile());
                 } else {
                     System.out.println("Name Details are  not found");
                 }
				break;
			 case 4:
                 System.out.println("Please enter the Id of the Patient_Name to update:");
                 int Id = in.nextInt();
                 
                 if (!dao.checkModelExists(Id)) {
                     System.out.println("There is no existing details!!!");
                 } else {

                 System.out.println("Please enter new Patient Name:");
                 String newName = in.next();

                 System.out.println("Please enter new Patient Wardno:");
                 int newWardno = in.nextInt();

                 System.out.println("Please enter new Patient Disease:");
                 String newDisease = in.next();
                 
                 System.out.println("Please enter new Patient Mobile:");
 			     Long newMobile =in.nextLong();

                 Patient p1= new Patient();
                 p1.setId(Id);
                 p1.setName(newName);
                 p1.setWardno(newWardno);
                 p1.setDisease(newDisease);
                 p1.setMobile(newMobile);

                 int Status = dao.update_Patient_Details(p1);
                 if (Status >= 1) {
                     System.out.println("Patient Details are Updated!!!");
                     System.out.println("-------------------------");
                     System.out.println(p1.getId()+"\t"+p1.getName()+"\t"+p1.getWardno()
						+"\t"+p1.getDisease()+"\t"+p1.getMobile());
                 }else {
                	 
                     System.out.println("Failed to update the details!!!");
                 }
                 }
                 break;
			 case 5:
                 System.out.println("Please enter the brand of the Patient to delete:");
                 String dname = in.next();
                 int dStatus = dao.delete_Patient_Details(dname);
                 if (dStatus >= 1) {
                     System.out.println("Patient Details are Deleted!!!");
                 } else {
                     System.out.println("There is no such Patient brand to delete!!!");
                 }
                 break;
			 case 6:
                 dao.delete_All_Patient_Details();
                 System.out.println("All Patient Details are Deleted!!!");
                 break;
			case 0:
				System.out.println("Byee!!!");
				in.close();
				System.exit(0);

			default:
				System.out.println("Invalide Option!!!!");
				break;
			}
    	}
    }
    }