package com.edubridge.Patient.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.Patient.Model1.Patient;
import com.edubridge.Patient.Utils.DBUtils;

public class PatientDAOIMPL implements PatientDAO{

	@Override
	public int add_Patient_Details(Patient p) {
	
			String INSERT ="insert into patient(id,name,wardno,disease,mobile) values(?,?,?,?,?)";
			Connection con=DBUtils.getConnection();
			int status=0;
			try {
				PreparedStatement ps=con.prepareStatement(INSERT);
				ps.setInt(1,p.getId());
				ps.setString(2,p.getName());
				ps.setInt(3,p.getWardno());
				ps.setString(4,p.getDisease());
				ps.setLong(5,p.getMobile());
				status=ps.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}

			return status;
		
	}

	@Override
	public List<Patient> get_All_Patient_Details() {
		String SELECT="select * from Patient";
		Connection con=DBUtils.getConnection();
		List<Patient> PatientDetails=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(SELECT);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Patient p=new Patient();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setWardno(rs.getInt("wardno"));
				p.setDisease(rs.getString("disease"));
				p.setMobile(rs.getLong("mobile"));
				PatientDetails.add(p);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return PatientDetails;
	
	}

	@Override
	public Patient get_Patient_Details(String name) {
		String SELECT = "SELECT * FROM Patient WHERE name= ?";
		Connection con=DBUtils.getConnection();
		Patient p1=null;
		 try {
	            PreparedStatement ps = con.prepareStatement(SELECT);
	            ps.setString(1,name);
	            ResultSet rs = ps.executeQuery();
	            
	            if (rs.next()) {
	                p1=new Patient();
	                p1.setId(rs.getInt("id"));
	                p1.setName(rs.getString("name"));
	                p1.setWardno(rs.getInt("wardno"));
	                p1.setDisease(rs.getString("disease"));
	                p1.setMobile(rs.getLong("mobile"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return p1;
	}
	

	@Override
	public int update_Patient_Details(Patient p) {
		String UPDATE = "UPDATE Patient SET name = ?, wardno = ?, disease = ?, mobile =? WHERE id = ?";
	    Connection con = DBUtils.getConnection();
	    int status = 0;
	    try {
	        PreparedStatement ps = con.prepareStatement(UPDATE);
	        ps.setString(1, p.getName());
	        ps.setInt(2, p.getWardno());
	        ps.setString(3, p.getDisease());
	        ps.setLong(4, p.getMobile());
	        ps.setInt(5, p.getId());
	        status = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	

	return status;
}
		
	

	@Override
	public int delete_Patient_Details(String name) {
		String DELETE = "Delete from Patient where name = ?";
	    Connection con = DBUtils.getConnection();
	    int status = 0;
	    try {
	        PreparedStatement ps = con.prepareStatement(DELETE);
	        ps.setString(1, name);
	        status = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

		return status;
	}
	

	@Override
	public void delete_All_Patient_Details() {
		String DELETEALL = "Delete from Patient";
	    Connection con = DBUtils.getConnection();
	    try {
	        PreparedStatement ps = con.prepareStatement(DELETEALL);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public boolean checkModelExists(int id) {
		String query = "SELECT * FROM Patient WHERE id = ?";
        Connection con = DBUtils.getConnection();
        boolean exists = false;
        try {
        	 PreparedStatement ps= con.prepareStatement(query);
        	 ps.setInt(1,id);
        	 ResultSet rs=ps.executeQuery();
        	 if (rs.next()) {
                 exists = rs.getInt(1) > 0;
             }
        }catch(SQLException e) {
        	e.printStackTrace();
        }

		return exists;
	}
	}


