//Service class for Bus
package com.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.dao.BusDao;
import com.dto.BusDto;

@Service
@Transactional
public class BusServices {
	@Autowired
	private BusDao bd;
	
		
	
	// get all bus info
	 
	    public  List<BusDto>   getBus() {
		 
		 List<BusDto> buses =bd.selectOp();
		 for(BusDto bdto: buses) {
			 System.out.println(bdto.toString());
		 }
		 return buses;
	        
	    }
	// get details about a particular bus
	
		public BusDto getBus(@PathVariable String bid)
		{
			BusDto b=bd.selectBus(Integer.parseInt(bid));
			System.out.println(b.toString());
			return b; 
		}
		 
		 //select bus by type
		 
		public List<BusDto> getBusByClass(@PathVariable String bus_type)
		{
			List<BusDto> buses=bd.selectBusByType(bus_type);
			for(BusDto bdto: buses) {
				System.out.println(bdto.toString());
			 }
			return buses; 
		}
		 
	 //select bus by destination
		
		public List<BusDto> getBusByDest(@PathVariable String dest)
		{
			List<BusDto> buses=bd.selectBusByDest(dest);
			for(BusDto bdto: buses) {
				System.out.println(bdto.toString());
			 }
			return buses; 
		}
		 
		 // Find bus between two stations
		
		 public List<BusDto> getFoos(@RequestParam String from,@RequestParam String to) {
			 
			List<BusDto> buses=bd.FindBus(from,to);
			for(BusDto bdto: buses) {
				System.out.println(bdto.toString());
			 }
		    return buses;
		 }
		 
		 
		  //Adding a bus.
		
		public String addBus(
					 @RequestParam int bid,
			         @RequestParam String bname ,
			         @RequestParam String fromloc,
			         @RequestParam String toloc,
			         @RequestParam String bus_type,
			         @RequestParam int total_seats
			        
			
			 )
			{
			     BusDto bdto  = new BusDto(bid , bname , fromloc , toloc , bus_type , total_seats );
			     bd.addbus(bdto);;
			     return "Entry added Succesfully: "+bdto.toString();
			 }
		 
		 // check seat availability for a particular date for a bus.
		
		 public String seatsAvailable(@RequestParam int bid,@RequestParam String travel_date) {
			 
			int seatleft=bd.seatAvailability(bid,travel_date);
			System.out.println(seatleft);
		    return seatleft+" number of seats left";
		 }

	 



}
