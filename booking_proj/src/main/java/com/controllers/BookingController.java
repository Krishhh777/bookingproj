//Controller class for Bookings.
package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.dto.BookingsDto;
import com.services.BookingServices;


@RestController
public class BookingController {
	
	@Autowired
	private BookingServices bookingservice;
		
	
	// Select all bookings list
	
	 @GetMapping("/getbookingsinfo")
	 @ResponseBody
	    public  List<BookingsDto>  getBookings() {
		 
		return bookingservice.getBookings();
	        
	    }
	
	//select a particular booking based on bookid
	
	@GetMapping("/booking/{bookid}")
	@ResponseBody
	public BookingsDto getUser(@PathVariable String bookid)
	{
		return bookingservice.getUser(bookid);
	}
	
	
	
	  @GetMapping("/booking/history/{pid}")
	  
	  @ResponseBody public List<BookingsDto> getBookHistory(@PathVariable String pid)
	  {
		 return bookingservice.getBookHistory(pid);
	  }
	  
	  //Booking bus  tickets.
	  @PostMapping("/bookticket")
		@ResponseBody
		 public String addBus(
				 @RequestParam int bookid,
		         @RequestParam int pid ,
		         @RequestParam int bid,
		         @RequestParam String travel_date,
		         @RequestParam int seat_num
	
		
		 )
		{
		     
		     return bookingservice.addBus(bookid, pid, bid, travel_date, seat_num);
		 }
	 

}
