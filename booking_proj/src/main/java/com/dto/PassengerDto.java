//Dto class for Passenger entity.

package com.dto;

public class PassengerDto {
	private int pid;
	private String pname;
	private String mobile;
	//Getters,setters and toString method.
	public PassengerDto() {
		super();
		
	}
	public PassengerDto(int pid, String pname, String mobile) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.mobile = mobile;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "PassengerDto [pid=" + pid + ", pname=" + pname + ", mobile=" + mobile + "]";
	}
	

}
