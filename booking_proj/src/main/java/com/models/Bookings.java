//Bookings Entity.
package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Bookings {
	@Id
	private int bookid;
	
    @ManyToOne
    @JoinColumn(name="pid") 
 	private Passenger passenger;
	
	@ManyToOne
	@JoinColumn(name="bid") 
	private Bus bus;
	
	private String travel_date;
	private int seat_num;
	//Getters and setters.
	public Bookings() {
		super();
		
	}
	public Bookings(int bookid, Passenger passenger, Bus bus, String travel_date, int seat_num) {
		super();
		this.bookid = bookid;
		this.passenger = passenger;
		this.bus = bus;
		this.travel_date = travel_date;
		this.seat_num = seat_num;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public String getTravel_date() {
		return travel_date;
	}
	public void setTravel_date(String travel_date) {
		this.travel_date = travel_date;
	}
	public int getSeat_num() {
		return seat_num;
	}
	public void setSeat_num(int seat_num) {
		this.seat_num = seat_num;
	}
	

}
