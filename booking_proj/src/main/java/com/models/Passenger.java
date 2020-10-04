//Passenger entity.
package com.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {
	@Id
	private int pid;
	private String pname;
	private String mobile;
	
	@OneToMany(mappedBy="passenger")
	private List<Bookings> bookings;
	
	//Getters and setters.
	public Passenger() {
		super();
	
	}
	

	public Passenger(int pid, String pname, String mobile) {
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

	
	

}
