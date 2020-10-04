//Dao class for Bus.
package com.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.dto.BusDto;
import com.models.Bookings;
import com.models.Bus;

@Repository
public class BusDao {
	SessionFactory factory=null;
	 Session session = null;
	 Transaction tx = null;
	 
	 BusDao(){
		 
		 try{
			 factory = new Configuration().configure().addAnnotatedClass(Bus.class).buildSessionFactory();
	        }
	        catch (Throwable throwable){
	            System.out.println("Error");
	            throw new ExceptionInInitializerError(throwable);
	        }
	 }
	 //method to export Dto.
		public BusDto exportDto (Bus bus1) {
			BusDto bdto=new BusDto();
			bdto.setBid(bus1.getBid());
			bdto.setBname(bus1.getBname());
			bdto.setFromloc(bus1.getFromloc());
			bdto.setToloc(bus1.getToloc());
			bdto.setBus_type(bus1.getBus_type());
			bdto.setTotal_seats(bus1.getTotal_seats());
			return bdto;
			
		}
		//method to import Dto.
		public Bus importDto(BusDto bdto) {
			Bus bus= new Bus();
			bus.setBid(bdto.getBid());
			bus.setBname(bdto.getBname());
			bus.setFromloc(bdto.getFromloc());
			bus.setToloc(bdto.getToloc());
			bus.setTotal_seats(bdto.getTotal_seats());
			return bus;
		}
		//Select operation.
	 public List<BusDto> selectOp() {
		
	 	session = factory.openSession();
        tx = session.beginTransaction();
        String hql="from com.models.Bus";
        List<Bus> buses = session.createQuery(hql).list();
        List<BusDto> busdtolist = new ArrayList<>();
        for(Bus b: buses) {
        	busdtolist.add(exportDto(b));
        	
        }
        tx.commit();
        session.close();
        System.out.println("succsess");
        return busdtolist;      	
  
	 }
	 //Select by id.
	 public BusDto selectBus(int bid) {
		 session = factory.openSession();
         tx = session.beginTransaction();
         Bus b=session.get(Bus.class, bid);
         tx.commit();
         session.close();
         System.out.println("succsess");
         return exportDto(b);
         
	 }
	 //Select by type.
	 public List<BusDto> selectBusByType(String bus_type) {
		 session = factory.openSession();
         tx = session.beginTransaction();
         
         
         Criteria crit = session.createCriteria(Bus.class);
         crit.add(Restrictions.eq("bus_type",bus_type));
         List<Bus> results = crit.list();
         List<BusDto> busdtolist = new ArrayList<>();
         for(Bus b: results) {
         	busdtolist.add(exportDto(b));
         	
         }
         tx.commit();
         session.close();
         System.out.println("succsess");
         return busdtolist;
         
	 }
	 //Select by destination.
	 public List<BusDto> selectBusByDest(String toloc) {
		 session = factory.openSession();
         tx = session.beginTransaction();
         
         
         Criteria crit = session.createCriteria(Bus.class);
         crit.add(Restrictions.eq("toloc",toloc));
         List<Bus> results = crit.list();
         List<BusDto> busdtolist = new ArrayList<>();
         for(Bus b: results) {
         	busdtolist.add(exportDto(b));
         	
         }
         tx.commit();
         session.close();
         System.out.println("succsess");
         return busdtolist;
         
	 }
	 //selection by filtering.
	public List<BusDto> FindBus(String from, String to) {
		
		session = factory.openSession();
        tx = session.beginTransaction();
        
        
        Criteria crit = session.createCriteria(Bus.class);
        crit.add(Restrictions.eq("fromloc",from));
        crit.add(Restrictions.eq("toloc",to));
        List<Bus> results = crit.list();
        List<BusDto> busdtolist = new ArrayList<>();
        for(Bus b: results) {
        	busdtolist.add(exportDto(b));
        	
        }
        tx.commit();
        session.close();
        System.out.println("succsess");
        return busdtolist;
	}
	//adding bus.
	public void addbus(BusDto bdto) {
		
		session = factory.openSession();
        tx = session.beginTransaction();
        
        session.save(importDto(bdto));
        
        tx.commit();
        session.close();
        System.out.println("succsess");
		
	}
	
	// find seats available
	public int seatAvailability(int bid,String travel_date) {
		
		session = factory.openSession();
        tx = session.beginTransaction();
        
        Bus bus=session.get(Bus.class,bid);
        
        Criteria crit = session.createCriteria(Bookings.class);
        crit.add(Restrictions.eq("travel_date",travel_date));
        crit.add(Restrictions.eq("bus",bus));
        List<Bookings> tickets = crit.list();
        BusDto bdto= exportDto(bus);
        int availability=bdto.getTotal_seats() - tickets.size();
                
        tx.commit();
        session.close();
        System.out.println("succsess");
		
		return availability;
	}
}
