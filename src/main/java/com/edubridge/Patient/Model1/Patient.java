package com.edubridge.Patient.Model1;

public class Patient {
	private int id;
	private String name;
	private int wardno;
	private String disease;
	private long mobile ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWardno() {
		return wardno;
	}
	public void setWardno(int wardno) {
		this.wardno = wardno;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
}
