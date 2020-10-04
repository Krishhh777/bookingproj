//Dao class for Passenger.
package com.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import com.dto.PassengerDto;
import com.models.Passenger;


@Repository
public class PassengerDao {
	
	SessionFactory factory=null;
	Session session = null;
	Transaction tx = null;
	 
	 PassengerDao(){
		 
		 try{
			 factory = new Configuration().configure().addAnnotatedClass(Passenger.class).buildSessionFactory();
	        }
	        catch (Throwable throwable){
	            System.out.println("Error");
	            throw new ExceptionInInitializerError(throwable);
	        }
	 }
	 //method to export Dto.
	 public PassengerDto exportDto (Passenger pass) {
		 
		 PassengerDto pdto = new PassengerDto();
		 pdto.setPid(pass.getPid());
		 pdto.setPname(pass.getPname());
		 pdto.setMobile(pass.getMobile());
		 return pdto;
		}
	 //method to import Dto.
	 public Passenger importDto(PassengerDto pdto) {
			Passenger pass= new Passenger();
			pass.setPid(pdto.getPid());
			pass.setPname(pdto.getPname());
			pass.setMobile(pdto.getMobile());
			return pass;
			
		}
	 //Select all.
	 public List<PassengerDto> selectOp() {
		 
		 		session = factory.openSession();
	            tx = session.beginTransaction();
	            String hql="from com.models.Passenger";
	            List<Passenger> passengers = session.createQuery(hql).list();
	            List<PassengerDto> passdtolist = new ArrayList<>();
	            for(Passenger p:passengers) {
	            	passdtolist.add(exportDto(p));
	            	
	            }
	            tx.commit();
	            session.close();
	            System.out.println("succsess");
	            return passdtolist;      	
	      
	 }
	 //Select Passenger by id.
	 public PassengerDto selectPassenger(int pid) {
		 session = factory.openSession();
         tx = session.beginTransaction();
         Passenger p=session.get(Passenger.class, pid);
         tx.commit();
         session.close();
         System.out.println("succsess");
         return exportDto(p);
         
	 }
	 //Add passenger.
	public void addPassenger(PassengerDto pdto) {
		session = factory.openSession();
        tx = session.beginTransaction();
        
        session.save(importDto(pdto));
        tx.commit();
        session.close();
        System.out.println("succsess");
        
		
	}

}
