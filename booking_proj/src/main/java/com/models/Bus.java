//Bus entity.
package com.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="bus")
public class Bus {

	@Id
	private int bid;
	private String bname;
	private String fromloc;
	private String toloc;
	private String bus_type;
	private int total_seats;
	
	
	@OneToMany(mappedBy="bus")
	private List<Bookings> bookings=new ArrayList<Bookings>();
	
	//Getters and setters.
	public Bus(){}
	
	
	
	public Bus(int bid, String bname, String fromloc, String toloc, String bus_type, int total_seats) {
		
		this.bid = bid;
		this.bname = bname;
		this.fromloc = fromloc;
		this.toloc = toloc;
		this.bus_type = bus_type;
		this.total_seats = total_seats;
	}



	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getFromloc() {
		return fromloc;
	}
	public void setFromloc(String fromloc) {
		this.fromloc = fromloc;
	}
	public String getToloc() {
		return toloc;
	}
	public void setToloc(String toloc) {
		this.toloc = toloc;
	}
	public String getBus_type() {
		return bus_type;
	}
	public void setBus_type(String bus_type) {
		this.bus_type = bus_type;
	}
	public int getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}
	
	
	
}
