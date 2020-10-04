//Service class for bookings.
package com.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.dao.BookingsDao;
import com.dto.BookingsDto;

@Service
@Transactional
public class BookingServices {
	@Autowired
	private BookingsDao bd;
		
	
	// Select all bookings list
	
	
	    public  List<BookingsDto>  getBookings() {
		 
		 List<BookingsDto> bookings =bd.selectOp();
		 for(BookingsDto bkdto: bookings) {
			 System.out.println(bkdto.toString());
		 }
	     return bookings; 
	    }
	
	//select a particular booking based on bookid.
	
	
	public BookingsDto getUser(@PathVariable String bookid)
	{
		BookingsDto b=bd.selectBooking(Integer.parseInt(bookid));
		 System.out.println(b.toString());
		return b; 
	}
	
	
	//Select booking history a passenger by passenger id.
	public List<BookingsDto> getBookHistory(@PathVariable String pid)
	  {
		  List<BookingsDto> history=bd.selectBookHistory(Integer.parseInt(pid));
		  for(BookingsDto bkdto: history) {
			  System.out.println(bkdto.toString());
			 }
		  return history;
	  }
	  
	  //Booking bus  tickets.
	
	 public String addBus(
				 @RequestParam int bookid,
		         @RequestParam int pid ,
		         @RequestParam int bid,
		         @RequestParam String travel_date,
		         @RequestParam int seat_num
	
		
		 )
		{
		     
		     int status=bd.bookTicket(bookid,pid,bid,travel_date,seat_num);
		     if(status==1) {
		    	 return "Ticket booked Succesfully";
		     }
		     else if(status==-1)
		    	 return "Invalid seat number";
		     else if(status==-2)
		    	 return "Seat already booked!!";
		     else
		    	 return "No seats left";
		     
		 }
	 



}
