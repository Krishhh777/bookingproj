//Controller class for Bus.
package com.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.services.BusServices;
import com.dto.BusDto;



@RestController
public class BusController {
	@Autowired
	private BusServices busService;
	
		
	
	// get all bus info.
	 
	 @GetMapping("/getbusinfo")
	 @ResponseBody
	 public  List<BusDto>  getBus() {
		 return busService.getBus();
	        
	    }
	// get details about a particular bus.
	 
	 @GetMapping("/bus/{bid}")
	 @ResponseBody
		public BusDto getBus(@PathVariable String bid)
		{
			return busService.getBus(bid);
		}
		 
	//select bus by type.
		 
	 @GetMapping("/bus/byclass/{bus_type}")
	 @ResponseBody
		public List<BusDto> getBusByClass(@PathVariable String bus_type)
		{
			return busService.getBusByClass(bus_type);
		}
		 
	 //select bus by destination
		 
		 @GetMapping("/bus/bydest/{dest}")
		 @ResponseBody
		public List<BusDto> getBusByDest(@PathVariable String dest)
		{
			return busService.getBusByDest(dest);
		}
		 
		 // Find bus between two stations.
		 
		 @GetMapping("/bus/find")
		 @ResponseBody
		 public List<BusDto> getFoos(@RequestParam String from,@RequestParam String to) {
			 
			return busService.getFoos(from, to);
		 }
		 
		 
		 //Adding bus.
		 @PostMapping("/addbus")
			@ResponseBody
			 public String addBus(
					 @RequestParam int bid,
			         @RequestParam String bname ,
			         @RequestParam String fromloc,
			         @RequestParam String toloc,
			         @RequestParam String bus_type,
			         @RequestParam int total_seats
			        
			
			 )
			{
			     
			     return busService.addBus(bid, bname, fromloc, toloc, bus_type, total_seats);
			    
			 }
		 
		 // check seat availability for a particular date for a bus.
		 
		 @GetMapping("/bus/seatleft")
		 @ResponseBody
		 public String seatsAvailable(@RequestParam int bid,@RequestParam String travel_date) {
			 
			return busService.seatsAvailable(bid, travel_date);
		 }

	 

}
