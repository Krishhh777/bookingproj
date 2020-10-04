//Controller class for Passenger.
package com.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.dto.PassengerDto;
import com.services.PassengerServices;

@RestController
public class PassengerController {
	
	@Autowired
	private PassengerServices passService;
	
	
	//get all passengers list
	@GetMapping("/getpassengerinfo")
	@ResponseBody
	    public  List<PassengerDto>  getPassenger() {
		 
		return passService.getPassenger();
	        
	    }
	    
	
	//get a selected passenger info
	
	@GetMapping("/passenger/{pid}")
	@ResponseBody
	public PassengerDto getUser(@PathVariable String pid)
	{
		return passService.getUser(pid);
	}
	//Adding a passenger.
	@PostMapping("/addpassenger")
	@ResponseBody
	 public String addPassenger(
			 @RequestParam int pid,
	         @RequestParam String pname ,
	         @RequestParam String mobile
	
	 )
	{
	    return passService.addPassenger(pid, pname, mobile);
	 }
	
	

}

