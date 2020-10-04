//Dto class for Bus entity.
package com.dto;

public class BusDto {
	private int bid;
	private String bname;
	private String fromloc;
	private String toloc;
	private String bus_type;
	private int total_seats;
	
	//Getters,setters and toString method.
	public BusDto(){
		
	}
	
	
	
	public BusDto(int bid, String bname, String fromloc, String toloc, String bus_type, int total_seats) {
		
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



	@Override
	public String toString() {
		return "BusDto [bid=" + bid + ", bname=" + bname + ", fromloc=" + fromloc + ", toloc=" + toloc + ", bus_type="
				+ bus_type + ", total_seats=" + total_seats + "]";
	}
	
	
	


}
