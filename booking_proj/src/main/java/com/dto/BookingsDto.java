//Dto class for Bookings entity.
package com.dto;

public class BookingsDto {
	private int bookid;
	private int pid;
	private int bid;
	private String travel_date;
	private int seat_num;
	//Getters,setters and toString method.
	public BookingsDto() {
		super();
		
	}
	public BookingsDto(int bookid, int pid, int bid, String travel_date, int seat_num) {
		super();
		this.bookid = bookid;
		this.pid = pid;
		this.bid = bid;
		this.travel_date = travel_date;
		this.seat_num = seat_num;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
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
	@Override
	public String toString() {
		return "BookingsDto [bookid=" + bookid + ", pid=" + pid + ", bid=" + bid + ", travel_date=" + travel_date
				+ ", seat_num=" + seat_num + "]";
	}
	

}
