//Service class for Passenger.
package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.dao.PassengerDao;
import com.dto.PassengerDto;

@Service
@Transactional
public class PassengerServices {
	@Autowired
	private PassengerDao passdao;
	
	//get all passengers list
	
	    public  List<PassengerDto>  getPassenger() {
		 
		 List<PassengerDto> pass =passdao.selectOp();
		 for(PassengerDto bdto: pass) {
			System.out.println(bdto.toString());
		 }
		 return pass;
	        
	    }
	    
	
	//get a selected passenger info
	
	
	public PassengerDto getUser(@PathVariable String pid)
	{
		PassengerDto p=passdao.selectPassenger(Integer.parseInt(pid));
		System.out.println(p.toString());
		return p; 
	}
	
	//Adding passenger.
	 public String addPassenger(
			 @RequestParam int pid,
	         @RequestParam String pname ,
	         @RequestParam String mobile
	
	 )
	{
	     PassengerDto pdto  = new PassengerDto(pid , pname , mobile );
	     passdao.addPassenger(pdto);
	     return "User added Succesfully"+pdto.toString();
	 }
	
	



}
